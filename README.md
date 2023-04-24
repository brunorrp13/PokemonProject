# PokemonProject

Pokemon Project was made in Kotlin (Android) and it has two-screens: A page with the list of Pokemons from the API: https://pokeapi.co/api/v2/ and a page with the details from each Pokemon (that is displayed when the selected Pokemon is clicked on).

## Architectural Pattern - MVVM
The architectural pattern chosen for the project was MVVM due to the clear separation between the Data Layer (that has the API mapping and the Pokemon model) the UI Layer and the repository.

## Dependency Injection - Dagger Hilt
The Google library Dagger Hilt was used for dependency injection because of its flexibility and practical way of building the dependencies as Singletons and having a readable structure with modules.

## Test
A class was created with tests for the API using a Mock Web Server, the Truth library and Mockito.
