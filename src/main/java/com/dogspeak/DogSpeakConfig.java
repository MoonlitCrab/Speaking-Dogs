package com.dogspeak;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

	@ConfigGroup("dog talk")
	public interface DogSpeakConfig extends Config {
		@ConfigItem(
				keyName = "dog id",
				name = "Dog ID (Hover me with your mouse) ",
				description = "What is your dogs NPC ID?<br>" +
							  "<br>" +
		                      "Bernese Mountain Dog Puppy (Chocolate/Merle/Toasted) (16457/16458/16459)<br>" +
			                  "Bernese Mountain Dog (Chocolate/Merle/Toasted) (16385/16386/16387)<br>" +
						      "<br>" +
						      "Border Collie Puppy (Chocolate/Merle/Black and white) (16442/16443/16444)<br>" +
				              "Border Collie (Chocolate/Merle/Black and white) (16367/16368/16369)<br>" +
						      "<br>" +
						      "Chihuahua Puppy (Tan/White/Toasted) (16439/16440/16441)<br>" +
							  "Chihuahua (Tan/White/Toasted) (16364/16365/16366)<br>" +
						      "<br>" +
							  "Corgi Puppy (Tan/Fawn/Toasted) (16445/16446/16447)<br>" +
							  "Corgi (Tan/Fawn/Toasted) (16370/16371/16372)<br>" +
							  "<br>" +
							  "Greyhound Puppy (Tan/Grey/Cream) (16448/16449/16450)<br>" +
							  "Greyhound (Tan/Grey/Cream) (16373/16374/16375)<br>" +
							  "<br>" +
							  "Husky Puppy (Black and white/Grey/Chocolate) (16436/16437/16438)<br>" +
						  	  "Husky (Black and white/Grey/Chocolate) (16376/16377/16378)<br>" +
							  "<br>" +
							  "Labrador Puppy (Golden/Chocolate/Black) (16433/16434/16435)<br>" +
						      "Labrador (Golden/Chocolate/Black) (16361/16362/16363)<br>" +
							  "<br>" +
							  "Pug Puppy (Fawn/Brown/Black) (16451/16452/16453)<br>" +
							  "Pug (Fawn/Brown/Black) (16379/16380/16381)<br>" +
							  "<br>" +
							  "Samoyed Puppy (White/Golden/Brown) (16454/16455/16456)<br>" +
							  "Samoyed (White/Golden/Brown) (16382/16383/16384)<br>" +
						      "<br>" +
							  "Shiba Puppy (Tan/White/Toasted) (16460/16461/16462)<br>" +
						      "Shiba (Tan/White/Toasted) (16388/16389/16390)<br>" +
							  "<br>" +
							  "Spaniel Puppy (Red/White/Black) (16463/16464/16465)<br>" +
							  "Spaniel (Red/White/Black) (16391/16392/16393)<br>" +
						  	  "<br>" +
						      "Yorkie Puppy (Brown/White/Golden) (16466/16467/16468)<br>" +
							  "Yorkie (Brown/White/Golden) (16394/16395/16396)",

				position = 1
		)
		default String dog_id() {
			return "1";
		}

		@ConfigItem(
				keyName = "space",
				name = "<html><br><br><br><br><br></html>",
				description = "",
				position = 2
		)
		default void space1() {}

		@ConfigItem(
				keyName = "dogpetlines",
				name = "Dog Pet Lines (Hover me)",
				description = "Enter custom overhead text when petting your dog (separate multiple with commas)",
				position = 3
		)
		default String dog_pets() {

			return "Howdy,Begone Master";
		}

		@ConfigItem(
				keyName = "space",
				name = "<html><br></html>",
				description = "",
				position = 4
		)
		default void space3() {}

		@ConfigItem(
				keyName = "dogdiglines",
				name = "Dog Dig Lines (Hover me)",
				description = "Enter custom overhead text when your dog digs (separate multiple with commas)",
				position = 5
		)
		default String dog_digs() {

			return "Mine,Not Yours,Treasure";
		}

		@ConfigItem(
				keyName = "space",
				name = "<html><br></html>",
				description = "",
				position = 6
		)
		default void space4() {}

		@ConfigItem(
				keyName = "dogfoodlines",
				name = "Dog Food Lines (Hover me)",
				description = "Enter custom overhead text when your dog is fed (separate multiple with commas)",
				position = 7
		)
		default String dog_food() {

			return "Mmmmmmmm,Delicioso,Yuck";
		}

		@ConfigItem(
				keyName = "space",
				name = "<html><br></html>",
				description = "",
				position = 8
		)
		default void space5() {}

		@ConfigItem(
				keyName = "dogidlelines",
				name = "Dog Idle Lines (Hover me)",
				description = "Enter custom overhead text when your dog is idle (separate multiple with commas)",
				position = 9
		)
		default String dog_idle() {

			return "BOOOORING,Can we kill something else?";
		}

		@ConfigItem(
				keyName = "space",
				name = "<html><br><br><br><br><br><br><br><br><br><br></html>",
				description = "",
				position = 10
		)
		default void space6() {}

		@ConfigItem(
				keyName = "dog dig id",
				name = "Dog Dig ID (Hover me)",
				description = "DO NOT CHANGE, ONLY CHANGE THIS TO 14498 IF THE DIGGING LOOKS OFF",
				position = 11
		)
		default String dog_dig_id() {
			return "14499";
		}
	}