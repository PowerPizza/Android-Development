# Android Navigation
This is example of how android navigation can be implemented in android using java and xml.  
Android navigation helps user to navigate through different pages of app and come back to previous pages.  

⚠ This example is uses java + xml not kotlin.

Android navigation provides several benefits like :-
* Full support of fragment transaction.
* Transition between the switching of fragment
* Read more about benefits at [Benefits and features](https://developer.android.com/guide/navigation#benefits)

# Required Dependencies
* `implementation "androidx.navigation:navigation-fragment:$nav_version"`
* `implementation "androidx.navigation:navigation-ui:$nav_version"`

# Key Concepts
## NavGraph or Navigation Graph
* It is a xml resource created under `res/navigation/any_file_name.xml`.
* Android studio provides *navigation editor* to edit navigation resource.
* This resource defines **NavDestination** or **Navigation Destinations** i.e. - from which fragment to which fragment transaction should allowed etc.
* Basically it connects all the fragments to each other so that user can jump from one fragment to another.

## Host or Navigation Host Fragment
* It is also called **navHostFragment** and is created using `<fragment></fragment>` element.
* It should be present in the activity in which we need to perform navigation because during navigation the fragments are replaced in `<fragment></fragment>` (*navHostFragment*).
* Generally it should be present in `activity_main.xml` assuming that we are making app by following **single activity architecture**.
* Two most required attributes should be present in `<fragment></fragment>` element.
  1. `android:name="androidx.navigation.fragment.NavHostFragment"`
  2. `app:navGraph="@navigation/your_nav_graph"`

## NavController or Navigation Controller
* A **NavController** object is associated with each **NavHostFragment** or `<fragment></fragment>` element if they have both attributes (discussed in 2nd point) defined properly.
* **NavController** helps in switching between fragments according to the pattern declared in **NavGraph**.
* **NavController** associated with **NavHostFragment** can be accessed in java file (*MainActivity.java*) using `Navigation.findNavController()`
* **NavController** object provides methods like `navigate()`, `popBackStack()` to navigate to a fragment or go back to previous fragment respectively.

# How to setup
### Step 1 : Fragment Creation
1. Create different fragments for each page. (ex - *HomeFragment*, *ProfileFragment*, *AboutFragment*)
2. Make sure to put each fragments in different package within application's package.  
As in this example - fragments *HomeFragment*, *AboutFragment* and *ProfileFragment* are present in *about_page*, *home_page* and *profile_page* packages respectively within the application's package (*com.example.android_navigation*).

### Step 2 : Creating Navigation Graph
1. Create a resource directory in `res/` with name `navigation`.
2. Create a *navigation resource file* inside `res/navigation`.
3. Open navigation resource file and add new destination by clicking `new destination` option in navigation editor of android studio.  
4. Add all the fragments and connect them accordingly as you want your user to navigate through.  
As for this example I want user to navigate from `HomeFragment to AboutFragment` and from `HomeFragment to ProfileFragment` so I connected home fragment with profile and about fragments in navigation editor.  
Notice that as you are connecting the fragments in navigation editor, in component tree (*bottom right side*) there are **action id's** are adding something like `action_homeFragment_to_profileFragment`. Remember it, these id's are gonna be used while navigation form java code.
5. Make sure to select a **startDestination** fragment else you app might crash,

### Step 3 : Creating Navigation Host Fragment
1. Go into **activity_main.xml** and create a **FrameLayout** inside which create `<fragment></fragment>` element.
2. Carefully set an id like - `android:id="@+id/nav_host_frag"` to `<fragment></fragment>` element.
3. Carefully set `android:name="androidx.navigation.fragment.NavHostFragment"` attribute as it is.
4. Carefully attach your navigation resource file (*created in previous section*) in `app:navGraph="@navigation/your_nav_res_file"` attribute.
5. Create 3 buttons *home*, *about*, *profile* in **activity_main.xml** file inside main constrain layout.  
Note that its only if you are following this example, these button will help us to notice navigation by interaction, you can implement same logic in different ways.

### Step 4 : Creating Navigation Controller
1. Go into **MainActivity.java** and get access of **NavController** in previously created *NavHostFragment* using `Navigation.findNavController(findViewById(R.id.nav_host_frag));`  
Note that `R.id.nav_host_frag` should be id of `<fragment></fragment>` element created in previous step.
2. It will return **NavController** type object store it as shown in this example's **MainActivity.java**
3. Use `navigate()` method to navigate to the desired action that we noticed while creating **NavGraph**. (*check MainActivity.java for reference*)
4. Use `popBackStack()` method to go back to last navigated fragment.

# Source
This example is created with reference to the *android docs* and my experiments.  
To learn more about navigation check out android docs :-  
> [Overview of android navigation](https://developer.android.com/guide/navigation)

> [Design your navigation graph](https://developer.android.com/guide/navigation/design)

> [Create a navigation controller](https://developer.android.com/guide/navigation/navcontroller)

> [Navigate to a destination](https://developer.android.com/guide/navigation/use-graph/navigate)