# djanpto

![Java](https://img.shields.io/badge/java-1.8-orange.svg?style=flat)
![Gradle](https://img.shields.io/badge/gradle-2.14-green.svg?style=flat)
![Build](https://img.shields.io/badge/build-passing-brightgreen.svg?style=flat)
![Release](https://img.shields.io/badge/release-1.0.0-blue.svg?style=flat)
![License MIT](https://img.shields.io/badge/license-MIT-lightgray.svg?style=flat&maxAge=2592000)

```
 ____  _                   _        
|  _ \(_) __ _ _ __  _ __ | |_ ___  
| | | | |/ _` | '_ \| '_ \| __/ _ \ 
| |_| | | (_| | | | | |_) | || (_) |
|____// |\__,_|_| |_| .__/ \__\___/ 
    |__/            |_|                    
```

**Djanpto** implement the build in password crypto algorithm of **django** framework with **java** language.

Django is a popular web framework for python with build in orm and lot of features.<br> 
The build in password crypto algorithm which django have is awesome. <br>
Now, I implement it with java language.<br>
 
## Installation

Download [the latest JAR](http://central.maven.org/maven2/me/mervinz/djanpto/1.0.0/djanpto-1.1.0.jar) or using **Maven**:
 
 ```xml
 <dependency>
   <groupId>me.mervinz</groupId>
   <artifactId>djanpto</artifactId>
   <version>1.0.0</version>
 </dependency>
 ```
 
 or **Gradle**:
 
 ```groovy
 compile 'me.mervinz:djanpto:1.0.0'
 ```
 
## Runtime

Java 7+

## Usage

### Algorithms

There are 4 algorithms supported.

- PBKDF2SHA1
- PBKDF2SHA256
- PBKDF2SHA512
- PBKDF2MD5

### Make Password

Make password with default algorithm and random salt.

```java
import me.mervinz.djanpto.PasswordUtil;

public class Demo {
    public static void main(String args[]) {
    
        // setup plain password
        String plainPassword = "myplainpassword";
        
        // Make encoded password
        String encodedPassword = PasswordUtil.makePassword(plainPassword);
    }
}
```

Make password with specified algorithm, salt an iterations.

```java
import me.mervinz.djanpto.PasswordUtil;
import me.mervinz.djanpto.Algorithm;

public class Demo {
    public static void main(String args[]) {
        
        // setup plain password
        String plainPassword = "myplainpassword";
        
        // setup salt value
        String salt = "mysalt";
        
        // setup iterations to 1000
        int iter = 1000;
        
        // setup algorithm to PBKDF2SHA512
        Algorithm algorithm = Algorithm.PBKDF2SHA512;
        
        // Make encoded password
        String encodedPassword = PasswordUtil.makePassword(plainPassword, salt, iter, algorithm);
    }
}
```

### Check Password

```java
import me.mervinz.djanpto.PasswordUtil;

public class Demo {
    public static void main(String args[]) {
        String plain = "plainpassword";
        String encoded = "encodedpassword";
        if (PasswordUtil.checkPassword(plain, encoded) {
            // valid
        } else {
            // invalid
        }
    }
}
```

## Contributing

1. Fork it.
2. Create your feature branch. (`$ git checkout feature/my-feature-branch`)
3. Commit your changes. (`$ git commit -am 'What feature I just added.'`)
4. Push to the branch. (`$ git push origin feature/my-feature-branch`)
5. Create a new Pull Request

## Authors

[@Mervin](https://github.com/mofei2816) 

## License

The MIT License (MIT). For detail see [LICENSE](LICENSE).