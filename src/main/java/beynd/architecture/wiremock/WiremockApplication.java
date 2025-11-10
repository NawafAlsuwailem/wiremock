package beynd.architecture.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class WiremockApplication {
	public static void main(String[] args) {
		WireMockConfiguration config = WireMockConfiguration.options()
				.port(8090)
				.usingFilesUnderClasspath("wiremock");

		WireMockServer server = new WireMockServer(config);
		server.start();

		System.out.println("✅ WireMock standalone server running at http://localhost:8090");

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			server.stop();
			System.out.println("🛑 WireMock stopped");
		}));
	}
}
