# CQRS with Kafka Demo
It is have two service Command and Query.
# Command service is used to create a record.
# Query service is used to fetch the record.

Both services are seprated in Microservices approach.
Command service : When create a new record or update an existing record, tells to the kafka. 
and from kafka Query service will get the update on same.
