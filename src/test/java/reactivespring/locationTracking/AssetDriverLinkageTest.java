package reactivespring.locationTracking;

import com.example.locationtracking.NonReactiveSpringLocationTrackingApp;
import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.entity.DeviceType;
import com.example.locationtracking.nonreactive.service.AssetDriverLinkageService;
import com.example.locationtracking.nonreactive.service.AssetManagementService;
import com.example.locationtracking.web.dto.AssetDTO;
import com.example.locationtracking.web.dto.AssetTrackingConfigDTO;
import com.example.locationtracking.web.dto.AssetUpdateInfoDTO;
import java.time.LocalTime;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NonReactiveSpringLocationTrackingApp.class)
@TestPropertySource(locations="classpath:test.properties")
public class AssetDriverLinkageTest extends BaseTest {

    @Autowired
    private AssetDriverLinkageService assetDriverLinkageService;

    @Autowired
    private AssetManagementService assetManagementService;

    @Test
    public void testDeLinkVehicleDevice(){
        AssetDTO assetDTO = getAssetDTO();
        String assetId = assetManagementService.addNewAsset(getAssetDTO());
        assetDriverLinkageService.deLinkDriverFromAsset(assetId);
        Optional<Assets> assetsOptional = assetManagementService.getAssetById(assetId);
        if(assetsOptional.isPresent()){
            if(DeviceType.MOBILE.equals(assetsOptional.get().getDeviceType())){
                Assert.assertTrue(StringUtils.isEmpty(assetsOptional.get().getDriverName()) && assetsOptional.get().getTrackingInfo() == null);
            }
            else {
                Assert.assertTrue(StringUtils.isEmpty(assetsOptional.get().getDriverName()));
            }

        }
    }

    @Test(expected = RuntimeException.class)
    public void testLinkToLinkedAsset(){
        AssetDTO assetDTO = getAssetDTO();
        String assetId = assetManagementService.addNewAsset(getAssetDTO());

        AssetUpdateInfoDTO updateInfoDTO = new AssetUpdateInfoDTO();
        updateInfoDTO.setAssetId(assetId);
        updateInfoDTO.setDriverName("change");
        assetDriverLinkageService.linkDriverToAsset(updateInfoDTO);
    }

    @Test
    public void testLinkVehicle(){
        AssetDTO assetDTO = getAssetDTO();
        String assetId = assetManagementService.addNewAsset(getAssetDTO());
        assetDriverLinkageService.deLinkDriverFromAsset(assetId);

        AssetUpdateInfoDTO assetUpdateInfoDTO = new AssetUpdateInfoDTO();
        assetUpdateInfoDTO.setAssetId(assetId);
        assetUpdateInfoDTO.setDriverName("Changed Driver");
        assetUpdateInfoDTO.setDeviceType(DeviceType.MOBILE);
        AssetTrackingConfigDTO trackingConfigDTO = new AssetTrackingConfigDTO();
        trackingConfigDTO.setTrackFromTime(LocalTime.of(10,0,0));
        trackingConfigDTO.setTrackToTime(LocalTime.of(12,0,0));
        trackingConfigDTO.setTrackingFrequency(LocalTime.of(0,0,10));
        trackingConfigDTO.setPhoneNumber("9849984998");
        trackingConfigDTO.setUserName("a@b.com");
        assetUpdateInfoDTO.setTrackingConfig(trackingConfigDTO);
        assetDriverLinkageService.linkDriverToAsset(assetUpdateInfoDTO);

        Optional<Assets> assetsOptional = assetManagementService.getAssetById(assetId);
        if(assetsOptional.isPresent()){
            Assert.assertTrue(DeviceType.MOBILE.equals(assetsOptional.get().getDeviceType()));
        }
        else {
            Assert.fail();
        }
    }

}
