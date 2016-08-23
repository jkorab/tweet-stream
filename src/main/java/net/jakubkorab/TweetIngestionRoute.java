package net.jakubkorab;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author jkorab
 */
@Component
public class TweetIngestionRoute extends RouteBuilder {

    private String latitude;
    private String longitude;
    private Integer radius;

    @Value("${near.latitude}")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Value("${near.longitude}")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Value("${near.radius}")
    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    @Override
    public void configure() throws Exception {
        fromF("twitter:search?keywords=traffic&latitude=%s&longitude=%s&radius=%s&distanceMetric=km",
                latitude, longitude, radius).autoStartup(false)
            .split(body())
            .log("Received: ${body}");

        from("timer:ping?period=5000")
            .log("Ping");
    }
}
