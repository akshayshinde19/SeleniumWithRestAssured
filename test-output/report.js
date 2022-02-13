$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/GitRepo.feature");
formatter.feature({
  "name": "Git Repo",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verify Git repo names and description",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sanity"
    }
  ]
});
formatter.step({
  "name": "User Launch Chrome browser",
  "keyword": "Given "
});
formatter.step({
  "name": "User opens URL \"\u003crepoURL\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "Move to Repositories section",
  "keyword": "And "
});
formatter.step({
  "name": "get all Repo titles and desc from API using \"\u003cAPIUrl\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "get all Repo titles and desc from UI",
  "keyword": "And "
});
formatter.step({
  "name": "Verify Actual data of UI with Expected data from API",
  "keyword": "Then "
});
formatter.step({
  "name": "close browser",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "repoURL",
        "APIUrl"
      ]
    },
    {
      "cells": [
        "https://github.com/django",
        "https://api.github.com/orgs/django/repos"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify Git repo names and description",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sanity"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Launch Chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef.user_Launch_Chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User opens URL \"https://github.com/django\"",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdef.user_opens_URL(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Move to Repositories section",
  "keyword": "And "
});
formatter.match({
  "location": "Stepdef.move_to_Repositories_section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "get all Repo titles and desc from API using \"https://api.github.com/orgs/django/repos\"",
  "keyword": "And "
});
formatter.match({
  "location": "Stepdef.get_all_Repo_titlesAndDesc_fromAPI(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "get all Repo titles and desc from UI",
  "keyword": "And "
});
formatter.match({
  "location": "Stepdef.get_all_Repo_titlesAndDesc_fromUI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify Actual data of UI with Expected data from API",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef.verify_Actual_data_of_UI_with_Expected_data_from_API()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "close browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef.close_browser()"
});
formatter.result({
  "status": "passed"
});
});