package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.PrintUtils;
import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;

import static com.codepath.apps.simpletwitterclient.utils.PrintUtils.collectionString;


public class SymbolEntity extends _SymbolEntity implements Entity, PrintUtils.Printable {

  public static final DualCreator<SymbolEntity> CREATOR = new DualCreator<SymbolEntity>() {

    public SymbolEntity[] newArray(int size) {
      return new SymbolEntity[size];
    }

    public SymbolEntity createFromParcel(Parcel source) {
      SymbolEntity object = new SymbolEntity();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public SymbolEntity parse(JSONObject obj) throws JSONException {
      SymbolEntity newInstance = new SymbolEntity();
      newInstance.readFromJson(obj);
      return newInstance;
    }
  };

  @Override
  public String getLink() {
    return "";
  }

  @Override
  public String getDisplayLink() {
    return getText();
  }

  @Override
  public int getStart() {
    return (int) getIndices().get(0);
  }

  @Override
  public int getEnd() {
    return (int) getIndices().get(1);
  }

  @Override
  public String[] getPrintKeys() {
    String[] labels = {
        "text",
        "indices"
    };

    return labels;
  }

  @Override
  public String[] getPrintValues() {
    String[] values = {
        getText(),
        collectionString(getIndices())
    };

    return values;
  }
}
