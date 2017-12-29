# SmartImageView [![](https://jitpack.io/v/TeleClinic/SmartImageView.svg)](https://jitpack.io/#TeleClinic/SmartImageView)
Smart Image View for Android where you can add multiple images and choose the shape and size


# Screenshot
<img src="Screenshot_20171229-115827.png" height="400" />

# Integration
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.TeleClinic:SmartImageView:1.0.0'
	}
	
Step 1. Add the JitPack repository to your build file
	
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	
Step 2. Add the dependency

	<dependency>
	    <groupId>com.github.TeleClinic</groupId>
	    <artifactId>SmartImageView</artifactId>
	    <version>1.0.0</version>
	</dependency>
	
# How to Use

Only thing you have to do is giving as many URLs as you want to the Layout with putImages function. Shape and size can be arranged via XML file. 

    <com.teleclinic.bulent.smartimageview.SmartImageViewLayout
        android:id="@+id/images1"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_margin="24dp"
        android:layout_gravity="center"
        app:shape="SQUARE"/>

    <com.teleclinic.bulent.smartimageview.SmartImageViewLayout
        android:id="@+id/images2"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_margin="24dp"
        android:layout_gravity="center"
        app:shape="CIRCLE"/>
	
	images1.putImages(url1, url2, ...)
	images2.putImages(url1)
	
Library being used to show pictures is Glide (https://github.com/bumptech/glide).
