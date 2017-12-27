package reactivespring.locationTracking;

import com.example.locationtracking.entity.DeviceType;
import com.example.locationtracking.web.dto.AssetDTO;
import com.example.locationtracking.web.dto.AssetTrackingConfigDTO;
import java.time.LocalTime;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class BaseTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void cleanTests(){
        mongoTemplate.getDb().drop();
    }


    protected AssetDTO getAssetDTO(){
        AssetDTO assetDTO = new AssetDTO();
        assetDTO.setVehicleNumber("TS07UA8888");
        assetDTO.setDriverName("Kailash");
        assetDTO.setDeviceType(DeviceType.GPS_DEVICE);
        AssetTrackingConfigDTO assetTrackingConfigDTO = new AssetTrackingConfigDTO();
        assetTrackingConfigDTO.setDeviceId("abc");
        assetTrackingConfigDTO.setManufacturer("SAMSUNG");
        assetTrackingConfigDTO.setTrackFromTime(LocalTime.of(10,0,0));
        assetTrackingConfigDTO.setTrackToTime(LocalTime.of(12,0,0));
        assetTrackingConfigDTO.setTrackingFrequency(LocalTime.of(0,0,10));
        assetDTO.setTrackingConfig(assetTrackingConfigDTO);
        return assetDTO;
    }
}
