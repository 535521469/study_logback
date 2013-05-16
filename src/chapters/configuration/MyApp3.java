package chapters.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class MyApp3 {
	final static Logger logger = LoggerFactory.getLogger(MyApp3.class);

	public static void main(String[] args) {
		// assume SLF4J is bound to logback in the current environment
		LoggerContext context = (LoggerContext) LoggerFactory
				.getILoggerFactory();

		try {
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(context);
			// Call context.reset() to clear any previous configuration, e.g.
			// default
			// configuration. For multi-step configuration, omit calling
			// context.reset().
			context.reset();
			// configurator.doConfigure("src/duplicate.xml");
			// configurator.doConfigure("src/restricted.xml");
			// configurator.doConfigure("src/additivityFlag.xml");
			// configurator.doConfigure("src/contextName.xml");
//			 configurator.doConfigure("src/variableSubstitution1.xml");
//			 configurator.doConfigure("src/variableSubstitution3.xml");
//			 configurator.doConfigure("src/contextScopedVariable.xml");
//			 configurator.doConfigure("src/variableSubstitution4.xml");
//			 configurator.doConfigure("src/insertFromJNDI.xml");
			 configurator.doConfigure("src/containingConfig.xml");

			 
		} catch (JoranException je) {
			// StatusPrinter will handle this
		}
		StatusPrinter.printInCaseOfErrorsOrWarnings(context);

		logger.info("Entering application.");

		Foo foo = new Foo();
		foo.doIt();
		logger.info("Exiting application.");
	}
}