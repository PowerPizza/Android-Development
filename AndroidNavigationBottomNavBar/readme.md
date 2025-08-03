# Android Navigation With Bottom Navigation Bar
In this example we are going to see how to connect bottom navigation bar with android navigation which we have learned in [Android-Navigation]() example. Do check it out first before moving here.

# Target
We have to create a bottom navigation bar and connect it to navigation or navigation graph so that user can easily navigate through different fragmanets of app by clicking options of bottom navigation bar.  
Also we need to add top tool bar such that if user has navigated to different fragment other than homeFragment then they see a back arrow icon in top tool bar clicking on which they can come back to home fragment.

# Creating fragments
* Create different fragments in different packages inside application's package.
* For more info about creating fragments checkout [fragment creation](https://github.com/PowerPizza/Android-Development/tree/master/Android-Navigation#step-1--fragment-creation)

# Setup navigation
* Setup navigation and its components navHostFragment, navGraph, NavController as per the [Android-Navigation](https://github.com/PowerPizza/Android-Development/tree/master/Android-Navigation#android-navigation)

# Setting up Tool Bar
* To create tool bar add `<androidx.appcompat.widget.Toolbar />` element to `activity_main.xml`.
* Set attributes of ToolBar properly, specially id (***tool_bar** for this example*) and theme.
* In java file use `Toolbar tb = findViewById(R.id.tool_bar);` to get app's tool bar.
* Call `setSupportActionBar(tb);` which tells system to use tool bar as app's native action bar.

# Setting up bottom navigation bar
* To setup bottom navigation bar add `<com.google.android.material.bottomnavigation.BottomNavigationView />` in `activity_main.xml`.
* Create a new resource folder in `res/` named `menu`.
* Create a menu resource file in `res/menu/`
* Add `<item></item>` elements to the menu resource file with proper id and icon and title. for this example I have added home, profile, about items.  
Note that ID of menu item should be same as its corresponding destination (_<fragment /> element of navigation resource file_) in navigation graph.
* Use `app:menu` attribute of bottom navigation bar to set menu resource file as options of bottom navigation bar.

# Connecting bottom navigation bar with navigation
* Obtain navController using `NavController ctrl = Navigation.findNavController(findViewById(R.id.nav_host_frag));`
* Obtain bottom navigation bar widget using `BottomNavigationView bottom_nav = findViewById(R.id.bottm_nav_bar);`
* Use `setupWithNavController()` of `NavigationUi` class to link bottom navigation bar with navigation controller as follows `NavigationUI.setupWithNavController(bottom_nav, ctrl);`
* Now as user will click different options of bottom navigation bar they will redirect to different pages/fragments of app.

# Implementing back to home destination
* Obtain ToolBar using `Toolbar tb = findViewById(R.id.tool_bar);`
* Create AppBarConfiguration which have navController's navGraph linked with it using `AppBarConfiguration app_bar_conf = new AppBarConfiguration.Builder(ctrl.getGraph()).build();`.
* Use overloaded method setupWithNavController() of NavigationUi class to link ToolBar with navigation controller and AppBarConfiguration.
* Now as user will switch on to different fragment a back arrow icon will appear in top tool bar clicking on which they can come back to home destination.
