# Introduction

This is a project which collects data for machine learning. The idea is to periodically scrape the rss feed of different news sources and use them for different ml learning purposes 

## List of modules

    - rss data collector - This is a module whcich scrapes the rss data feed from provided rss sources.
    
## Rss data Collector
    Rss data collector collects data from multiple rss data feeds and persist it to a data store (Mongo DB). 
    
#Requirement for scrapper
    Scrapper is a continiously running utility whic scrappes the given endoints and stores it as partitioned parquet files
    Features:
        * configurations are read from yaml files
        * Is continious
        * able to partition (generate folder structure) accoring to the configuration
        * Able to store data as parquet files locally on the machine
        * Able to perform scrapping based on time based configuration
        * Able to deduplicate Enteries
        
#High Level Design:
   ------------------
   
   Model:
   A model representing a Rss data is created for every feed
   A metadata is being tagged along with every instance of model
   Metadata is generic and is key value based, no complex keys are allowed
   
   A network unit
   is responsible for the network transfer and dealing with retries ans handling errors
   
   A parsing Unit
   is responsible for parsing the output of network unit and produce model. Able to handle and log parsing errors
   
   A contral Logic unit
   is responsible for upgraing models with metadata, decide if the model should be stored in data store, coordinating diferent parsing and network unit, validating configurations, trigger prediodically as per configurations, init the data store, holding all the other module objects and acts as a manager.
   
   A Dao / data store Abstraction
   is responsible for storing and retrving data from data store (parquet files) as model objects.
   
   Low Level Design:
   -----------------
   
   
   
   