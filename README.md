# githubrepo

App to fetch Github user and their repo.

![Debug CI](https://github.com/tasneembohra/githubrepo/workflows/Debug%20CI/badge.svg?branch=master)


## Getting Started

This project follows MVVP architecture and Single Activity architecture.

It contains Espresso UI Testing and JUnit, Mockito unit testing.

<img src="https://github.com/tasneembohra/githubrepo/blob/master/screenshot/list.png" alt="alt text" width="250" height="500"><img src="https://github.com/tasneembohra/githubrepo/blob/master/screenshot/dialog.png" alt="alt text" width="250" height="500">

### Prerequisites

Install the latest version of all of the following items:
- [Android Studio](https://developer.android.com/studio/)
- [JRE 8 / JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)


## Workflow

We follow the [Gitflow Workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow)

### Pull Request Naming

Use this template: `[Issue Number]: [Issue description]`

ex. 1244: User Repo Color

### Pull Request Updating to `develop`

Rather than pulling and merging changes from develop, and then pushing that merge as a commit to your PR, rebase your PR's branch onto develop.

## Resources

### Language and Architecture

- [Kotlin For Android](https://kotlinlang.org/docs/reference/android-overview.html)
- [Android Development Guidlines](https://developer.android.com/)
- [Material Design Guidlines](https://material.io/design)
- [Android Architecture Component](https://developer.android.com/topic/libraries/architecture)
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
  - [Life Cycle Aware Component](https://developer.android.com/topic/libraries/architecture/lifecycle)
  - [Databinding](https://developer.android.com/topic/libraries/data-binding)
- [Navigation Component](https://developer.android.com/guide/navigation)
- [Glide](https://github.com/bumptech/glide)

# Android Take Home Assignment

Your task is to create an Android app which communicates with the public Github API in order to display information about a specific user.

## Functional Requirements

The app should accept a github user's id as input and display the specified user's avatar and name. 

For each public repository owned by the user, the name and description are shown in a scrollable list. 

When a repository is selected, a card pops up with information about when it was last updated, how many stars it has, and how many times it has been forked. 

## Design Requirements

The expected design and behaviour of the app is shown in the associated screenshots and video. You should try to replicate the look and feel, as well as the animations as best as possible.

## API calls

The public Github API gives back a lot of information. For simplicity, you only need to parse specific fields from the json objects.

### User information

This call retrieves information about a specific user.

https://api.github.com/users/{userId}

The necessary fields from the return are:

```
{
    "name": String,
    "avatar_url": String
}
```

For example:

https://api.github.com/users/octocat

```
{
    "name": "The Octocat",
    "avatar_url": "https://avatars3.githubusercontent.com/u/583231?v=4"
}
```

### User Repos

This call retrives a list of public repositories owned by the specified user.

https://api.github.com/users/{userId}/repos

The necessary fields from the return are:
```
[
    {
        "name" : String,
        "description" : String,
        "updated_at" : String,
        "stargazers_count": Integer,
        "forks" : Integer
    }
]
```
For example:

https://api.github.com/users/octocat/repos

```
[
    {
        "name" : "Hello-World",
        "description" : "My first repository on GitHub!",
        "updated_at" : "2017-08-14T08:08:10Z",
        "stargazers_count": 1421,
        "forks" : 1176
    },
    ...
]
```

## Custom Views

Your project should feature an implementation of a custom view class where appropriate.

## Architectural Patterns

Your project should utilize Model-View-Presenter (MVP), Model-View-ViewModel (MVVM), or another relevant pattern. You should be able to explain your implementation, how the layers are organized and interact, and what the benefits are.

## Testing

Your project is required to have automated testing. These can be unit test, UI test, or both. You will need to be able to explain your testing approach and what is covered by these tests.

## Evaluation

Your assignment will be primarily be evaluated on the following criteria:

- cleanliness and organization
- testablilty
- functional requirements
- design requirements
- completion of tasks

For any tasks that could not be completed, you should be able to explain what you tried, and what blocked you from completing them.
