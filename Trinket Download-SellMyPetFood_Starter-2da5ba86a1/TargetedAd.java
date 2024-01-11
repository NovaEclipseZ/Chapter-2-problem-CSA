/*
 * Problem 2 Sell My Pet Food
 *
 * By Jadan Burkett
 * and Kara Smith kinda
 * and Benjamin Copeland and Aaron Selleck i guess
 */
public class TargetedAd {

  public static void main(String[] args)
  {

    DataCollector collector = new DataCollector();
    // USE THE ABSOLUTE PATH FROM YOUR OWN COMPUTER
    collector.setData("socialMediaPosts.txt","targetWords.txt");

    String usernames = "";
    String currentPost = "";
    String currentWord = "";
    int usernameSpaceThingamajig;
    boolean currentWordContained;
    boolean indicativeWordFound;

      /**
       * Loops through each post, gets usernames, and compares to target words
       */
    for (int i = 0; i < collector.getNumberOfPosts(); i++)
      {
          //Sets the basic boolean to false and gets the next posts to cycle through
          indicativeWordFound = false;
          currentPost = collector.getNextPost();
          usernameSpaceThingamajig = currentPost.indexOf(' ');
          //Takes in the amount of posts and loops through them
          for (int j = 0; j < collector.getNumberOfWords() && !indicativeWordFound; j++)
          {
              currentWord = collector.getNextTargetWord();
              currentWordContained = currentPost.toLowerCase().contains(currentWord);
              //checked if the target word is there. If so it stops the loop early
              if (currentWordContained)
              {
                  usernames = usernames.concat(currentPost.substring(0, (usernameSpaceThingamajig + 1)));
                  indicativeWordFound = true;
              }
          }
      }
    // Prepares advertisement outputs
    collector.prepareAdvertisement("sentAds.txt",usernames,"We bet your furry friend would love to smell our pet food!");

  }

}
