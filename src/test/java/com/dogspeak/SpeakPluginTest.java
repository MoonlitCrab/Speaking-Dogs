package com.dogspeak;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class SpeakPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(com.dogspeak.DogSpeakPlugin.class);
		RuneLite.main(args);
	}
}