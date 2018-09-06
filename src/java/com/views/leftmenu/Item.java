package com.views.leftmenu;

/**
 *
 * @author Nahuel Rullo <nahuelrullo at gmail.com>
 */
public class Item {

  private int id;
  private String displayName;
  private String name;
  private String uriAction;
  private String groupName;

  public Item() {
  }

  public Item(int id, String displayName, String name, String uriAction, String groupName) {
    this.id = id;
    this.displayName = displayName;
    this.name = name;
    this.uriAction = uriAction;
    this.groupName = groupName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUriAction() {
    return uriAction;
  }

  public void setUriAction(String uriAction) {
    this.uriAction = uriAction;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getGroupName() {
    return groupName;
  }

  @Override
  public String toString() {
    return name;
  }

}