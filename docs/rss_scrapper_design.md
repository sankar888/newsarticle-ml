## Rss Data Scrapper

This module should pull data from rss endpoint periodically and persist in a store, usually a no-sql db (or) a data warehouse.

##### Design Motivations
    - Should be simple and and adaptable to various data stores.
    - The configuration can be readable from a centralized location
    - If possible, the configuration changes should reflect in the process withoput any changes.
    - The parsing and other business logic should be pluggable and be easily adaptable to various other RSS protocols.
    - Should be able to handle intermittent rss data endpoint issues and network failures.
    - Should fail fast on basic issues.

### High Level Design
 
   