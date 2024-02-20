package com.pact.pact;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.StateChangeAction;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.MalformedURLException;
import java.net.URL;

@Provider("Animals")
@PactFolder("pacts")
public class PactProviderTest {
	private static final Logger logger = LogManager.getLogger(PactProviderTest.class);
	@TestTemplate
	@ExtendWith(PactVerificationInvocationContextProvider.class)
	void pactVerificationTestTemplate(PactVerificationContext context) {
			context.verifyInteraction();
	}

	@BeforeEach
	void before(PactVerificationContext context) throws MalformedURLException {
			//:3000 for next js app and :8080 for springboot app
			URL url = new URL("http://localhost:3000/");
			//Path is set in contract.
		    HttpTestTarget target = new HttpTestTarget(url.getHost(), url.getPort(), url.getPath());
			context.setTarget(target);
	}

	@State(value= "Zoo Animals exists", action = StateChangeAction.SETUP)
			public void zooAnimalsExist() {
	}

	@State(value= "Zoo Animals exists", action = StateChangeAction.TEARDOWN)
			public void zooAnimalsExistTeardown() {
	}
}