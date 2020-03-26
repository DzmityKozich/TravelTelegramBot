# TravelTelegramBot
This Telegram bot can be used to learn more about cities of the world.
## How to find this Bot
You can find this bot by name **Test Travel Bot** or by username **@TestTravelTelegramBot**.
## How to create Bot
### Creating a new Telgram Bot
You must to talk with **@BotFather**. It help you to create your own bot.
### Configure the Application
Create a new Spring Web Application with https://start.spring.io/.
Then add the following dependency to your pom:
```
<dependency>
	<groupId>com.github.xabgesagtx</groupId>
	<artifactId>telegram-spring-boot-starter</artifactId>
	<version>4.3</version>
</dependency>
```
After that set next field in your application.properties file:
````
bot.username=TestTravelTelegramBot
bot.token=1142419930:AAG4u7OtbHHbNRWwa10ZW8au3_MsOxcJbI0
````
The **bot.token** property has to be changed to your own bot token also as **bot.useraname**.

The only thing you need to do after adding the dependency is to create a bean for a bot:
````
@Component
public class TravelTelegramBot extends TelegramLongPollingBot {
...
}
````
The bot will then be registered for you automatically on startup.

## Built With
* [Spring](spring.io)
* [Maven](https://maven.apache.org/)
* [Telegram Spring Boot Starter](https://github.com/xabgesagtx/telegram-spring-boot-starter)
