### Example of update format:

---
**Path:** src/main/java/api/model/User.java
**Operation:** Create  
**Content:**

```java
public class User {
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

---

**Path**: src/main/java/service/UserService.java  
**Operation**: Update  
**Context Before:**
```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Integer id;
```
**Context After:**
```java

@Column(name = "type")
private String type;

```
**Content:**
```java
@Column(name = "name", unique = true)
private String name;
```
---

**Path**: src/main/java/service/UserService.java  
**Operation**: Delete