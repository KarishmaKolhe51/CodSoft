package com.dsa.entity;

public class LinkedList {

	 Node head;
	 Node tail;

	    public LinkedList() {
	        this.head = null;
	    }

	    public boolean checkRecord(int rollNo) {
	        Node temp = head;
	        while (temp != null) {
	            if (temp.data.rollNo == rollNo) {
	                return true;
	            }
	            temp = temp.next;
	        }
	        return false;
	    }

	  /*  public void createRecord(String name, int rollNo, String course, int marks) {
	        if (checkRecord(rollNo)) {
	            System.out.println("Record with Roll No. " + rollNo + " already exists!");
	        } else {
	            Student student = new Student(name, rollNo, course, marks);
	            Node newNode = new Node(student);
	            if (head == null) {
	                head = newNode;
	            } else {
	                Node temp = head;
	                while (temp.next != null) {
	                    temp = temp.next;
	                }
	                temp.next = newNode;
	            }
	            System.out.println("Record created successfully!");
	        }
	    }*/
	    
	    void createRecord(String name, int rollNo, String course, int marks) {
	    	
	    	   if (checkRecord(rollNo)) {
		            System.out.println("Record with Roll No. " + rollNo + " already exists!");}
		            else {
		            Student student = new Student(name, rollNo, course, marks);
		            Node newNode = new Node(student);

	        if  (head == null) {
	            head =newNode;
	          tail = newNode;
	         // newNode.next=null;
	        } else {
	            tail.next = newNode;
	            tail = newNode;
	        }
	        System.out.println("Record added successfully!");
	    }}

	    public void searchRecord(int rollNo) {
	        Node temp = head;
	        boolean found = false;
	        while (temp != null) {
	            if (temp.data.rollNo == rollNo) {
	                System.out.println(temp.data);
	                found = true;
	                break;
	            }
	            temp = temp.next;
	        }
	        if (!found) {
	            System.out.println("Record with Roll No. " + rollNo + " not found!");
	        }
	    }
	    


	    void searchRecordByName(String name) {
	        if (head == null) {
	            System.out.println("Record list is empty!");
	        } else {
	            Node temp = head;
	            boolean found = false;
	            while (temp != null) {
	                if (temp.data.name.equalsIgnoreCase(name)) {
	                   /* System.out.println("Record found:");
	                    System.out.println("Name: " + temp.data.name);
	                    System.out.println("Roll No: " + temp.data.rollNo);
	                    System.out.println("Course: " + temp.data.course);
	                    System.out.println("Marks: " + temp.data.marks);*/
	                	System.out.println(temp.data);
	                    found = true;
	                }
	                temp = temp.next;
	            }
	            if (!found) {
	                System.out.println("No record found with name: " + name);
	            }
	        }
	    }

	    public int deleteRecord(int rollNo) {
	        if (head == null) {
	            System.out.println("List is empty!");
	            return -1;
	        } else {
	            Node temp = head;
	            Node prev = null;
	            while (temp != null) {
	                if (temp.data.rollNo == rollNo) {
	                    if (prev == null) {
	                        head = temp.next;
	                    } else {
	                        prev.next = temp.next;
	                    }
	                    System.out.println("Record deleted successfully!");
	                    return 0;
	                }
	                prev = temp;
	                temp = temp.next;
	            }
	            System.out.println("Record with Roll No. " + rollNo + " not found!");
	            return -1;
	        }
	    }

	    public void showRecord() {
	        if (head == null) {
	            System.out.println("List is empty!");
	        } else {
	            Node temp = head;
	            while (temp != null) {
	                System.out.println(temp.data);
	                temp = temp.next;
	            }
	        }
	    }
}
