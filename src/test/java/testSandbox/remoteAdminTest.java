package testSandbox;

import http.RemoteAdminTestHttp;

import java.io.File;

public class remoteAdminTest {
    public static void main(String[] args) throws Exception {
//    	String host = ConfigTest.ADMANAGER_DOMAIN;
//    	String comando = "pwd";
//		SimpleHttpResponse shell = RemoteAdminTestHttp.shell(host,comando);
//		System.out.println(host);
//		System.out.println(shell.getBodyAsString());
//		
//		String fileName = "/tmp/monacao.xml";
//		String comando2 = "touch "+fileName;
//		RemoteAdminTestHttp.shell(comando2);
		createXMLFile("adfasdftesteeeeeeeeeeeeeeeeeeee1111111111");
		
	}
    
    
    public static String createXMLFile(String content) throws Exception {
    	
    	String filepath = "/tmp/monaco.xml";
		String comando2 = "touch "+filepath;
		RemoteAdminTestHttp.shell(comando2);

        final String echoThanGzipCmd = String.format("echo '%1$s' > %2$s", content, filepath);
        try {
        	 RemoteAdminTestHttp.shell(echoThanGzipCmd);
        } catch (Exception e) {
            System.err.println("erro ao invocar o comando: " + echoThanGzipCmd);
            throw e;
        }

        return new File(filepath).getName();
    }
    
}
