public class Operations
{
    Node insert_at_front(Node first)
    {
        Node temp = new Node();

        if(first==null)
        {
            first=temp;
            System.out.println(temp.item+" Inserted Successfully");
            return first;
        }

        temp.link=first;
        System.out.println(temp.item+" Inserted Successfully");
        return temp;
    }

    Node insert_at_rear(Node first)
    {
        Node temp = new Node();
        Node cur;

        if(first==null)
        {
            first=temp;
            System.out.println(temp.item+" Inserted Successfully");
            return first;
        }

        cur=first;

        while(cur.link!=null)
        {
            cur=cur.link;
        }

        cur.link=temp;
        System.out.println(temp.item+" Inserted Successfully");
        return first;

    }

    Node delete_at_front(Node first)
    {
        Node sec;

        if(first==null)
        {
            System.out.println("Linked List Is Empty");
            return first;
        }

        System.out.println(first.item+" Deleted Successfully");
        sec=first.link;
        first=sec;
        return first;
    }

    Node delete_at_rear(Node first)
    {
        Node cur,prev;

        if(first==null)
        {
            System.out.println("Linked List Is Empty");
            return first;
        }

        prev=null;
        cur=first;

        while(cur.link!=null)
        {
            prev=cur;
            cur=cur.link;
        }

        System.out.println(cur.item+" Deleted Successfully");
        prev.link=null;
        return first;
    }

    void display(Node first)
    {
        Node cur=first;

        if(first==null)
        {
            System.out.println("Linked List Is Empty");
            return;
        }

        System.out.println("The Contents Of Linked List Are Displayed Below");

        while (cur!=null)
        {
            System.out.println(cur.item);
            cur=cur.link;
        }
    }

    Node MergeAWithB(Node first1, Node first2)
    {
        Node cur;

        if(first1==null)
        {
            System.out.println("Linked List A Is Linked List B");
            return first2;
        }


        if(first2==null)
        {
            System.out.println("Linked List A Is Linked List A Only");
            return first1;
        }

        cur=first1;

        while(cur.link!=null)
        {
            cur=cur.link;
        }

        cur.link=first2;
        System.out.println("Linked List A Merged With Linked List B");
        return first1;
    }

    Node MergeBWithA(Node first2, Node first1)
    {
        Node cur;

        if(first2==null)
        {
            System.out.println("Linked List B Is Linked List A");
            return first1;
        }

        if(first1==null)
        {
            System.out.println("Linked List B Is Linked List B Only");
            return first2;
        }

        cur=first2;

        while(cur.link!=null)
        {
            cur=cur.link;
        }

        cur.link=first1;
        System.out.println("Linked List B Merged With Linked List A");
        return first2;
    }
}
