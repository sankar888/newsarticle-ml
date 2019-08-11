## Schema Design
This section is about the rss schema specification and how it is stores in internal data store.

### Rss Schema Specification
[Rss Specification](http://www.rssboard.org/rss-specification) describes the rss data model.
The specification used for the rss data collector is 2.0.11 of the RSS 2.0 specification published by the RSS Advisory Board on March 30, 2009.
The latest specification can be found on [current rss specification](http://www.rssboard.org/rss-specification)

### Design Problems
- [x] Rss is a xml. what to do with the scrapped content is not a valid xml or network errors ?
> Retry? - yes for Retriable Network Errors, for parsing errors simply log and proceed. Do not halt for Parsing errors

- [x] what if the rss document has unknown document fields
> Do not fail for unknown fields. Simply ignore the unknown fields. and get the content of known fields

- [x] what if the rss document doesn't have mandatory fields ? What fields are mandatory ?
> The rss feed can be of any version. try finding the version of the rss document first. Log if we couldn't support the rss version. 
only fields specified as mandatory by rss specification should be mandatory. If mandatory fiels is missing ignore the document and log the issue
The mandatory fields of Rss Specification 2.0.11 are
> - mandatory Elements for channel
>   - title: The name of the channel. It's how people refer to your service. If you have an HTML website that contains the same information as your RSS file, the title of your channel should be the same as the title of your website.	GoUpstate.com News Headlines
>   - link: The URL to the HTML website corresponding to the channel.	eg. http://www.goupstate.com/
>   - description: Phrase or sentence describing the channel.
> - Mandatory Elements for item
>   - All elements of an item are optional, however at least one of title or description must be present. 

- [x] what is the source of truth of rss schema in our system ?
> pojo? - can be the source of truth, or can do more by moving to schema based dynamic container. choosing the pojo based for now. keep it simple 

- [x] Corresponding schema of data store ?
> The rss xml file is 'channel' element containing one or more 'item' element. channel represents the rss source channel
> And item represents the news article from that particular source. going for flat structure. the channel information can be embedded in every item
> So there will be a single pojo which contains the flattened item and channel info 

- [ ] How to parse the incoming data to the model pojo?
> The incoming xml data can be parsed to custom object first, and then it can be mapped to pojo and then purged to store (or)
> The incoming xml data can be parsed to a reader, and then reader can be used to create the custom pojo, and then to store.
> Keeping it simple, decided to use pojo class and to use jackson-xml
 
### Resources

 1. [Sample Rss 2.0.11 file](http://www.rssboard.org/files/sample-rss-2.xml)
 2. [Rss Validator](http://www.rssboard.org/rss-validator/)
 3. [Jackson xml Annotations](https://github.com/FasterXML/jackson-dataformat-xml/wiki/Jackson-XML-annotations)

