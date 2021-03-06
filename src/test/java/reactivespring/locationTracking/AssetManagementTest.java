package reactivespring.locationTracking;

import com.example.locationtracking.NonReactiveSpringLocationTrackingApp;
import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.entity.DeviceType;
import com.example.locationtracking.nonreactive.service.AssetManagementService;
import com.example.locationtracking.web.dto.AssetDTO;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NonReactiveSpringLocationTrackingApp.class)
@TestPropertySource(locations="classpath:test.properties")
public class AssetManagementTest extends BaseTest {

    @Autowired
    private AssetManagementService assetManagementService;

    @Test
    public void testAddAsset(){
        String assetId = assetManagementService.addNewAsset(getAssetDTO());
        Assert.assertTrue(assetManagementService.getAssetById(assetId).isPresent());
    }

    @Test(expected = RuntimeException.class)
    public void testAddAssetWithoutGPSInfo(){
        AssetDTO assetDTO = getAssetDTO();
        assetDTO.getTrackingConfig().setDeviceId(null);
        assetManagementService.addNewAsset(assetDTO);
    }

    @Test(expected = RuntimeException.class)
    public void testAddAssetWithInvalidTrackingInfo(){
        AssetDTO assetDTO = getAssetDTO();
        assetDTO.getTrackingConfig().setDeviceId(null);
        assetDTO.getTrackingConfig().setManufacturer(null);
        assetManagementService.addNewAsset(assetDTO);
    }

    @Test
    public void testRemoveAsset(){
        String assetId = assetManagementService.addNewAsset(getAssetDTO());
        assetManagementService.removeAsset(assetId);
        Assert.assertTrue(!assetManagementService.getAssetById(assetId).isPresent());
    }

    @Test
    public void testFindAssetsByDeviceType(){
        assetManagementService.addNewAsset(getAssetDTO());
        List<Assets> mobileAssets = assetManagementService.findAllAssets(DeviceType.MOBILE);
        List<Assets> gpsAssets = assetManagementService.findAllAssets(DeviceType.GPS_DEVICE);
        Assert.assertTrue(gpsAssets.size() == 1 && mobileAssets.size() == 0);
    }

}
