package manual.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import chapters.configuration.Foo;

public class MyApp2 {
  final static Logger logger = LoggerFactory.getLogger(MyApp2.class);

  public static void main(String[] args) {
    logger.info("Entering application.");
    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    StatusPrinter.print(lc);
    Foo foo = new Foo();
    foo.doIt();
    logger.info("Exiting application.");
  }
}