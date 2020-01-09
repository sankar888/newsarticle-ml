package com.rssfeed.data;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.rssfeed.data.collector.rss.model.Rss;

public class TestJacksonParser {
    public static void main(String[] args) throws Exception {
        String rssString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<rss>\n" +
                "  <channel>\n" +
                "    <title><![CDATA[ India Today | Latest Stories  ]]></title>\n" +
                "    <description>India Today</description>\n" +
                "    <link><![CDATA[ http://indiatoday.intoday.in/?utm_source=rss ]]></link>\n" +
                "    <lastBuildDate>Sun, 11 Aug 2019 12:37:58 GMT </lastBuildDate>\n" +
                "    <generator>FeedCreator 1.7.2</generator>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ PoK terror launchpads full with terrorists attempting infiltration every night: Army commander ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/india/story/terror-launchpads-in-pok-full-with-terrorists-attempting-to-infiltrate-every-night-army-commander-1579770-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/india/story/terror-launchpads-in-pok-full-with-terrorists-attempting-to-infiltrate-every-night-army-commander-1579770-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/AP19217196125210-647x363.jpeg?Jw9hl8362iTK7OUJ6UkhPAlBS.FKcToA\"> </a> PoK terror launchpads full with terrorists attempting infiltration every night: Army commander]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 11:23:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ Pakistan minister says main India ke musalmano ki dil ki awaaz hun. Twitter can't stop laughing ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/trending-news/story/pakistan-minister-says-main-india-ke-musalmano-ki-dil-ki-awaaz-hun-twitter-can-t-stop-laughing-1579765-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/trending-news/story/pakistan-minister-says-main-india-ke-musalmano-ki-dil-ki-awaaz-hun-twitter-can-t-stop-laughing-1579765-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/imgonline-com-ua-FrameBlurred-_3-647x363.jpeg?M79P3ycGPg0RAcLz519Xpj3Vg70G8bGq\"> </a> Pakistan minister says main India ke musalmano ki dil ki awaaz hun. Twitter can't stop laughing]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 10:58:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ Elder brother who criminalised triple talaq: Muslim women in Varanasi send rakhis to PM Modi ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/india/story/elder-brother-who-criminalised-triple-talaq-muslim-women-in-varanasi-send-rakhis-to-pm-modi-1579710-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/india/story/elder-brother-who-criminalised-triple-talaq-muslim-women-in-varanasi-send-rakhis-to-pm-modi-1579710-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/f9tVBAckL4W7BrB7quNF20180825_1-647x363.png?QcI5xI3RIejI73A3nZysBxqH_HX_Qda9\"> </a> Elder brother who criminalised triple talaq: Muslim women in Varanasi send rakhis to PM Modi]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 07:32:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ Attempt to change demography of Kashmir: Pakistan PM attacks India over Article 370 move  ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/india/story/attempt-to-change-demography-of-kashmir-pakistan-pm-attacks-india-over-article-370-move-1579788-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/india/story/attempt-to-change-demography-of-kashmir-pakistan-pm-attacks-india-over-article-370-move-1579788-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/Imran_Khan-647x363.png?uJ1bN7qwbKRpuKeZTUqXQHKQ4pcEIeUB\"> </a> Attempt to change demography of Kashmir: Pakistan PM attacks India over Article 370 move ]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 12:29:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ Security alert issued in Delhi ahead of Independence Day ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/india/story/security-alert-issued-delhi-ahead-independence-day-1579784-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/india/story/security-alert-issued-delhi-ahead-independence-day-1579784-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/redfort-story_647_050517104211-647x363.jpeg?oNoNuXE_QHWMccM74gJTa08CVKt8fUys\"> </a> Security alert issued in Delhi ahead of Independence Day]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 12:25:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ Kashmir Live Updates: 300 special telephone booths being set up in J&K to help locals communicate with relatives ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/india/story/jammu-kashmir-ladakh-article-370-protests-valley-eid-live-updates-1579634-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/india/story/jammu-kashmir-ladakh-article-370-protests-valley-eid-live-updates-1579634-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/breaking_news/201908/firing-story_647_090216042420_-647x363.jpeg?kdBm0pzTl.ckIXrnQudPG6jmkp6sPnZ_\"> </a> Kashmir Live Updates: 300 special telephone booths being set up in J&K for locals]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 02:30:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ Mamata Banerjee attacks Centre over tax on Durga Puja, says will sit on dharna on August 13 ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/india/story/mamata-banerjee-attacks-centre-over-tax-on-durga-puja-says-will-sit-on-dharna-on-august-13-1579783-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/india/story/mamata-banerjee-attacks-centre-over-tax-on-durga-puja-says-will-sit-on-dharna-on-august-13-1579783-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/mamata-banerjee-lucknow-647_04-647x363.jpeg?Y6uIbm4oicyoEM32eIVGWbESJzefsxS5\"> </a> Mamata Banerjee attacks Centre over tax on Durga Puja]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 12:22:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ #MeToo: Mumbai police likely to close the rape case against Alok Nath. Here's why ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/television/top-stories/story/-metoo-mumbai-police-likely-to-close-the-rape-case-against-alok-nath-here-s-why-1579781-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/television/top-stories/story/-metoo-mumbai-police-likely-to-close-the-rape-case-against-alok-nath-here-s-why-1579781-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/alok-647x363.png?avvUxHB4jX0ieOWf0Jq9hgc3A4BqUMv7\"> </a> #MeToo: Mumbai police likely to close the rape case against Alok Nath. Here's why]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 12:03:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ 2 boiled eggs at Four Seasons Hotel, Mumbai costs Rs 1700, move over J W Marriott ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/trending-news/story/2-boiled-eggs-at-four-seasons-hotel-mumbai-costs-rs-1700-move-over-j-w-marriott-1579772-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/trending-news/story/2-boiled-eggs-at-four-seasons-hotel-mumbai-costs-rs-1700-move-over-j-w-marriott-1579772-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/four_seasons_hotel-647x363.jpeg?vRN_bOkj2XADW6xRbzwnhfCQT_F2ASWf\"> </a> 2 boiled eggs at Four Seasons Hotel, Mumbai costs Rs 1700, move over J W Marriott]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 11:29:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ Gandhis playing musical chair, Sonia's appointment proves Rahul was a blunder: BJP ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/india/story/gandhi-s-playing-musical-chair-sonia-s-appointment-proves-rahul-was-a-blunder-bjp-1579741-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/india/story/gandhi-s-playing-musical-chair-sonia-s-appointment-proves-rahul-was-a-blunder-bjp-1579741-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/odisha-bjp-leaders-meet-ec_1cf-647x363.jpeg?GbzB5zVRF.a0RizoOVv8pzlmANizNbTc\"> </a> Gandhis playing musical chair, Sonia's appointment proves Rahul was a blunder: BJP]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 09:44:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ The Kapil Sharma Show: Akshay Kumar’s childhood friend reveals his secret on the show ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/television/reality-tv/story/the-kapil-sharma-show-akshay-kumar-s-childhood-friend-reveals-his-secret-on-the-show-1579723-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/television/reality-tv/story/the-kapil-sharma-show-akshay-kumar-s-childhood-friend-reveals-his-secret-on-the-show-1579723-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/tkss_1-647x363.jpeg?FkuSiUeqNVqTSJssulV1nuKGdvJVmTie\"> </a> The Kapil Sharma Show: Akshay Kumar’s childhood friend reveals his secret on the show]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 08:25:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ Kerala floods Live Updates: Death toll touches 67, over 50 missing ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/india/story/flood-monsoon-rains-live-update-kerala-maharashtra-gujarat-karnataka-1579632-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/india/story/flood-monsoon-rains-live-update-kerala-maharashtra-gujarat-karnataka-1579632-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/breaking_news/201908/kerala_floods_0-647x363.png?jmLv1h5dwiP4WKQlhWa77i7E2bNiMAsw\"> </a> Kerala floods Live Updates: Death toll touches 67, over 50 missing]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 02:15:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ Zomato hits another controversy: Hindu, Muslim delivery boys to strike against delivering beef, pork ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/india/story/zomato-hits-another-controversy-hindu-muslim-delivery-boys-to-go-on-strike-against-delivery-of-beef-and-pork-1579684-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/india/story/zomato-hits-another-controversy-hindu-muslim-delivery-boys-to-go-on-strike-against-delivery-of-beef-and-pork-1579684-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/delivery-bike-647x363.jpeg?8EC7lIGPVOvxsKLv6q4L_DaYdEaV4gzJ\"> </a> Zomato hits another controversy: Hindu, Muslim delivery boys to strike against delivering beef, pork]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 06:22:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ Gandhi family wants to control Congress like a private company: Assam minister Himanta Biswa Sarma ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/india/story/gandhi-family-want-to-control-congress-like-a-private-company-assam-minister-himanta-biswa-sarma-1579762-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/india/story/gandhi-family-want-to-control-congress-like-a-private-company-assam-minister-himanta-biswa-sarma-1579762-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/India-Today-Himanta_0-647x363.jpeg?zmD9k_VfsVz0r9Psy6S1c9tWSNLJ7.6C\"> </a> Gandhi family wants to control Congress like a private company: Assam minister]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 10:59:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ Wasn't confused about consequences of removing Article 370: Amit Shah  ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/india/story/wasn-t-confused-about-consequences-of-removing-article-370-amit-shah-on-article-370-1579704-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/india/story/wasn-t-confused-about-consequences-of-removing-article-370-amit-shah-on-article-370-1579704-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/amit_shah_2-647x363.png?LWjGaWC4dmB5mFoj5fvgtPDBX7feSLLU\"> </a> Wasn't confused about consequences of removing Article 370: Amit Shah ]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 07:21:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ India vs West Indies 2nd ODI: Virat Kohli and Chris Gayle near major records ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/sports/cricket/story/india-vs-west-indies-2nd-odi-virat-kohli-and-chris-gayle-near-major-records-1579714-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/sports/cricket/story/india-vs-west-indies-2nd-odi-virat-kohli-and-chris-gayle-near-major-records-1579714-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/kohli11082019-647x363.jpeg?xxCzbz3xqW3uPKgLk4RELektAlgtk.Ws\"> </a> India vs West Indies 2nd ODI: Virat Kohli and Chris Gayle near major records]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 07:42:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ PM Modi and Amit Shah are like Krishna, Arjun, says actor Rajinikanth ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/india/story/amit-shah-and-modi-ji-is-like-krishna-arjuna-combo-says-rajinikanth-as-he-heaps-praises-on-kashmir-move-1579696-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/india/story/amit-shah-and-modi-ji-is-like-krishna-arjuna-combo-says-rajinikanth-as-he-heaps-praises-on-kashmir-move-1579696-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/rajinikanth_amit_shah_modi_kri_0-647x363.jpeg?Jm0TI6djwaT5J6W9KjOtI4fYOnPzVDk6\"> </a> PM Modi and Amit Shah are like Krishna, Arjun, says actor Rajinikanth]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 06:57:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "    <item>\n" +
                "      <title><![CDATA[ Roadies Real Heroes: Neha Dhupia pens emotional note as her gang's journey ends on the show ]]></title>\n" +
                "      <link><![CDATA[ https://www.indiatoday.in/television/reality-tv/story/roadies-real-heroes-neha-dhupia-pens-emotional-note-as-her-gang-s-journey-ends-on-the-show-1579681-2019-08-11?utm_source=rss ]]></link>\n" +
                "      <description><![CDATA[  <a href=\"https://www.indiatoday.in/television/reality-tv/story/roadies-real-heroes-neha-dhupia-pens-emotional-note-as-her-gang-s-journey-ends-on-the-show-1579681-2019-08-11\"> <img align=\"left\" hspace=\"2\" height=\"180\" width=\"305\" alt=\"\" border=\"0\" src=\"https://akm-img-a-in.tosshub.com/indiatoday/images/story/201908/neh-647x363.jpeg?o8.THJWJLdjU_OMoaOaSZ5P4_Dcc_ssw\"> </a> Roadies Real Heroes: Neha Dhupia pens emotional note as her gang's journey ends on the show]]></description>\n" +
                "      <pubDate> Sun, 11 Aug 2019 06:13:00 GMT</pubDate>\n" +
                "    </item>\n" +
                "  </channel>\n" +
                "</rss>\n";
        String testStr = "<pojo>\n" +
                "<id>101</id>\n" +
                "<name>sankar</name>\n" +
                "</pojo>";
        JacksonXmlModule xmlModule = new JacksonXmlModule();
        xmlModule.setDefaultUseWrapper(false);
        XmlMapper mapper = new XmlMapper(xmlModule);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);

        Rss pojo = mapper.readValue(rssString, Rss.class);
        System.out.println(pojo);
    }
}
