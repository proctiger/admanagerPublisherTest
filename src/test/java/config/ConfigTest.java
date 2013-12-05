package config;

import uol.remote.admin.config.client.proxy.ProxyFactory;

public class ConfigTest{
		protected static final RemoteConfig config = ProxyFactory.newInstance(RemoteConfig.class);
		public static final String ADMANAGER_DOMAIN = config.getAdmanageRemoteAdminTestDomain();
		public static final String ADMANAGER_HOST = config.getAdmanagerRemoteXmlHost();
		public static final int REQUEST_TIMEOUT = config.getRequestTimeout();
		public static final String PUBLISHER_DOMAIN = config.getAdmanagerPublisherDomain();
}
