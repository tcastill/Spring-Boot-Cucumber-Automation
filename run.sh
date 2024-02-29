#!/bin/bash

smoke(){
 mvn clean test -D"cucumber.filter.tags=@smoke" -Dspring.profiles.active=pilot-stable -Dbrowser=chrome -Dheadless=true -Pparallel
 allure serve target/allure-results
}

profile(){
 mvn clean test -Dcucumber.filter.tags=@smoke -Dbrowser=chrome -Dheadless=true -Pparallel
 allure serve target/allure-results
}

dockerup(){
  docker-compose up --d
}

dockerdown(){
  docker-compose down
}

dockerremove(){
  docker system prune -a --volumes
}

edge90() {
  docker-compose -f docker-compose-chrome.yaml up
}

# Check if the function exists (bash specific)
if declare -f "$1" > /dev/null
then
  # call arguments verbatim
  "$@"
else
  # Show a helpful error
  echo "'$1' You must pass a function to run: example pilotStable" >&2
  exit 1
fi
