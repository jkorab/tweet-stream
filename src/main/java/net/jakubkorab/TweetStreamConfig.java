package net.jakubkorab;

import org.apache.camel.component.twitter.TwitterComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jkorab
 */
@Configuration
public class TweetStreamConfig {

    private String accessToken;
    private String accessTokenSecret;
    private String consumerKey;
    private String consumerSecret;

    @Value("${accessToken}")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Value("${accessTokenSecret}")
    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }

    @Value("${consumerKey}")
    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    @Value("${consumerSecret}")
    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    @Bean(name = "twitter")
    public TwitterComponent twitterComponent() {
        TwitterComponent twitter = new TwitterComponent();
        twitter.setAccessToken(accessToken);
        twitter.setAccessTokenSecret(accessTokenSecret);
        twitter.setConsumerKey(consumerKey);
        twitter.setConsumerSecret(consumerSecret);
        return twitter;
    }
}
