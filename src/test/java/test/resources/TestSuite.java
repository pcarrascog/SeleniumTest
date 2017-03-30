package test.resources;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AboutFeature.class, AboutFeatureFirefox.class /*, BookFeature.class, TrackFeature.class*/})
public class TestSuite {

}
