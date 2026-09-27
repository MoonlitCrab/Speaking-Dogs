package com.dogspeak;

import com.google.gson.Gson;
import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.util.Random;

@Slf4j
@PluginDescriptor(
	name = "dog-speak"
)

public class DogSpeakPlugin extends Plugin {

	@Inject
	private Client client;
	private static final int PETTING = 827;

	@Inject
	private DogSpeakConfig config;

	private final Random random_dog_pet = new Random();
	private final Random random_dog_dig = new Random();
	private final Random random_dog_feed = new Random();
	private final Random random_dog_idle = new Random();
	private final Random random_dog_idle_two = new Random();
	private final Random random_puppy_idle = new Random();
	private final Random random_puppy_idle_two = new Random();

	private String[] dog_pet_array() {
		return config.dog_pets().split(",");
	}

	private String[] dog_dig_array() {
		return config.dog_digs().split(",");
	}

	private String[] dog_feed_array() {
		return config.dog_food().split(",");
	}

	private String[] dog_idle_array() {
		return config.dog_idle().split(",");
	}


	@Override
	protected void startUp() throws Exception {
		log.debug("Started");
	}

	@Override
	protected void shutDown() throws Exception {
		log.debug("Stopped");
	}

	@Subscribe

	public void onMenuOptionClicked(MenuOptionClicked event) {
		MenuEntry petClicked = event.getMenuEntry();
		NPC dog = petClicked.getNpc();

		if (dog == null) {
			return;
		}

		Player Crabby = client.getLocalPlayer();
		int dog_number = Integer.parseInt(config.dog_id());
		int dog_dig_number = Integer.parseInt(config.dog_dig_id());

		if ("Pet".equals(petClicked.getOption()) && dog_number == dog.getId()) {

			String[] pet_options = dog_pet_array();

			if (pet_options != null && pet_options.length > 0) {
				int randomIndex = random_dog_pet.nextInt(pet_options.length);
				String random_dog_pet_dialogue = pet_options[randomIndex];
				Crabby.setAnimation(PETTING);
				dog.setOverheadText(random_dog_pet_dialogue);
				dog.setOverheadCycle(250);
				client.playSoundEffect(12125);
				event.consume();
			}
		}
		if ("Dig".equals(petClicked.getOption()) && dog_number == dog.getId()) {

			String[] dig_options = dog_dig_array();

			if (dig_options != null && dig_options.length > 0) {
				int randomIndex = random_dog_dig.nextInt(dig_options.length);
				String random_dog_dig_dialogue = dig_options[randomIndex];
				dog.setAnimation(Integer.parseInt(config.dog_dig_id()));
				dog.setOverheadText(random_dog_dig_dialogue);
				dog.setOverheadCycle(250);
				client.playSoundEffect(1470);
				event.consume();
			}
		}
	}

	@Subscribe
	public void onOverheadTextChanged(OverheadTextChanged event) {

		if (!(event.getActor() instanceof NPC)) {
			return;
		}

		NPC dog = (NPC) event.getActor();

		if (dog.getId() != Integer.parseInt(config.dog_id())) {
			return;
		}

		if (dog.getId() == Integer.parseInt(config.dog_id())) {

			String[] feed_options = dog_feed_array();
			String[] idle_options = dog_idle_array();

            switch (event.getOverheadText()) {
				case "Woof woof!": {
					int randomIndex = random_dog_idle.nextInt(idle_options.length);
					String random_dog_idle_dialogue = idle_options[randomIndex];
					dog.setOverheadText(random_dog_idle_dialogue);
					dog.setOverheadCycle(250);
					break;
				}
				case "Woof": {
					int randomIndex = random_dog_idle_two.nextInt(idle_options.length);
					String random_dog_idle_dialogue = idle_options[randomIndex];
					dog.setOverheadText(random_dog_idle_dialogue);
					dog.setOverheadCycle(250);
					break;
				}
                case "Arf!": {
                    int randomIndex = random_dog_feed.nextInt(feed_options.length);
                    String random_dog_feed_dialogue = feed_options[randomIndex];
                    dog.setOverheadText(random_dog_feed_dialogue);
                    dog.setOverheadCycle(250);
                    break;
                }
				case "Arf arf!": {
					int randomIndex = random_puppy_idle.nextInt(idle_options.length);
					String random_dog_idle_dialogue = idle_options[randomIndex];
					dog.setOverheadText(random_dog_idle_dialogue);
					dog.setOverheadCycle(250);
					break;
				}
				case "Arfity": {
					int randomIndex = random_puppy_idle_two.nextInt(idle_options.length);
					String random_dog_idle_dialogue = idle_options[randomIndex];
					dog.setOverheadText(random_dog_idle_dialogue);
					dog.setOverheadCycle(250);
					break;
				}
            }
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (chatMessage.getType() != ChatMessageType.GAMEMESSAGE)
		{
			return;
		}

		String hungry = chatMessage.getMessage();

		if (hungry.contains("Your puppy is getting quite hungry.") ||
				hungry.contains("Your puppy is very hungry.") ||
				hungry.contains("Your puppy has stopped growing. You'll need to feed it for it to continue doing so."))
		{
			ChatLineBuffer buffer = client.getChatLineMap().get(chatMessage.getType().getType());
			if (buffer != null)
			{
				MessageNode[] hungry_lines = buffer.getLines();
				for (int hungry_number = 0; hungry_number < hungry_lines.length; hungry_number++)
				{
					if (hungry_lines[hungry_number] != null && hungry_lines[hungry_number].getValue().equals(hungry))
					{
						hungry_lines[hungry_number] = null;
						break;
					}
				}
			}
		}
	}

	@Provides
	DogSpeakConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DogSpeakConfig.class);
	}
}