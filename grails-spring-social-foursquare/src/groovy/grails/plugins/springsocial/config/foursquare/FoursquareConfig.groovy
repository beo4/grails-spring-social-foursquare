/* Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grails.plugins.springsocial.config.foursquare

import grails.plugins.springsocial.foursquare.SpringSocialFoursquareUtils
import javax.inject.Inject
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.social.connect.ConnectionFactory
import org.springframework.social.connect.ConnectionRepository
import org.springframework.social.foursquare.api.Foursquare
import org.springframework.social.foursquare.api.impl.FoursquareTemplate
import org.springframework.social.foursquare.connect.FoursquareConnectionFactory
import org.springframework.util.Assert

@Configuration
class FoursquareConfig {
  @Inject
  ConnectionRepository connectionRepository

  @Bean
  ConnectionFactory foursquareConnectionFactory() {
    println "Configuring SpringSocial Foursquare"
    def foursquareConfig = SpringSocialFoursquareUtils.config.foursquare
    String consumerKey = foursquareConfig.clientId ?: ""
    String consumerSecret = foursquareConfig.clientSecret ?: ""
    Assert.hasText(consumerKey, "The Foursquare clientId is necessary, please add to the Config.groovy as follows: grails.plugins.springsocial.foursquare.clientId='yourConsumerKey'")
    Assert.hasText(consumerSecret, "The Foursquare clientSecret is necessary, please add to the Config.groovy as follows: grails.plugins.springsocial.foursquare.clientSecret='yourConsumerSecret'")
    new FoursquareConnectionFactory(consumerKey, consumerSecret)
  }

  @Bean
  @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
  Foursquare foursquare() {
    def foursquare = connectionRepository.findPrimaryConnection(Foursquare)
    foursquare != null ? foursquare.getApi() : new FoursquareTemplate()
  }
}
