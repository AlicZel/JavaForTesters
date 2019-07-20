package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Relations extends ForwardingSet<RelationData> {

  private Set<RelationData> delegate;

  public Relations(Relations relations) {
    this.delegate=new HashSet<RelationData>(relations.delegate);
  }


  public Relations(Collection<RelationData> relations) {
    this.delegate=new HashSet<RelationData>(relations);
  }
  public Relations() {
    this.delegate=new HashSet<RelationData>();
  }




  @Override
  protected Set<RelationData> delegate() {
    return delegate;
  }

  public Relations withAdded(RelationData relation){
    Relations relations = new Relations(this);
    relations.add(relation);
    return  relations;

  }

  public Relations withOut(RelationData relation){
    Relations relations = new Relations(this);
    relations.remove(relation);
    return  relations;
  }
}
