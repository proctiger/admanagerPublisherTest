package config;

import uol.remote.admin.config.client.annotations.ConfigurationRepository;
import uol.remote.admin.config.client.annotations.RemoteConfigurationItem;

@ConfigurationRepository(product="admanager-test", component="admanager-test")
public interface RemoteConfig {
        
    @RemoteConfigurationItem(property="remote.admin.test.domain")
    String getAdmanageRemoteAdminTestDomain(); 
    
    @RemoteConfigurationItem(property="remote.xml.host")
    String getAdmanagerRemoteXmlHost(); 
    
    @RemoteConfigurationItem(property="request.timeout")
    int  getRequestTimeout();
    
    @RemoteConfigurationItem(property="remote.publisher.rest.domain")
    String  getAdmanagerPublisherDomain();
 
}
