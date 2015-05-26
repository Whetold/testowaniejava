package com.example.mockdemo.bdd;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.example.mockdemo.bdd.MessengerSteps;

public class MessengerTest extends JUnitStory {

	// Here we specify the configuration, starting from default
	// MostUsefulConfiguration, and changing only what is needed
	@Override
	public Configuration configuration() {
		//acquired from internet
		// where to find the stories																						 // CONSOLE and TXT reporting
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(this.getClass())).useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT));					
	}
	
	//specification of the steps classes
	@Override
	public InjectableStepsFactory stepsFactory() {
		// can have more that one steps classes
		return new InstanceStepsFactory(configuration(), new MessengerSteps());
	}
}
