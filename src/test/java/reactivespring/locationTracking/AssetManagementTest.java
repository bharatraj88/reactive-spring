package reactivespring.locationTracking;

import com.example.locationtracking.service.AssetManagementService;
import com.example.locationtracking.web.dto.AssetDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AssetManagementTest extends BaseTest {

    @Autowired
    private AssetManagementService assetManagementService;

    @Test
    public void testAddAsset(){
        String assetId = assetManagementService.addNewAsset(getAssetDTO());
        Assert.assertTrue(assetManagementService.getAssetById(assetId).isPresent());
    }

    @Test(expected = RuntimeException.class)
    public void testAddAssetWithoutTrackingInfo(){
        AssetDTO assetDTO = getAssetDTO();
        assetDTO.setTrackingConfig(null);
        assetManagementService.addNewAsset(assetDTO);
    }

    @Test(expected = RuntimeException.class)
    public void testAddAssetWithInvalidTrackingInfo(){
        AssetDTO assetDTO = getAssetDTO();
        assetDTO.getTrackingConfig().setDeviceId(null);
        assetDTO.getTrackingConfig().setManufacturer(null);
        assetManagementService.addNewAsset(assetDTO);
    }

}
