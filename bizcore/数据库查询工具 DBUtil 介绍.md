# **数据库查询工具 DBUtil 介绍**

DBUtil 提供了面象开发人员的查询 API，包括：

l 懒加载

l 模板查询

l 查询结果增强

此文档会详细介绍如何利用 DBUtil 进行查询，特别的查询模板的组装。

## **1.如何获得 DBUtil 实例**

DBUtil 被注册为了一个 Spring Bean(name = DBUtil),  所以你可以在你的组件里下面注入这个 Bean。比如

@Autowired private DBUtil dbUtil;

同时在一些情况下，你可以用以下静态方法：

DBUtil dbutil = Beans.dbUtil();

## 2.**懒加载以及懒加载方法**

我们的模型对象（pojo），除了 get 方法外，都实现了懒加载方法.  比如

Merchant merchant = Merchant.withId("M000001");

这里 merchant 只有一个 id，值为 M000001。

String name = merchant.getName()  // null，get 方法

name = merchant.name()  //  懒加载方法，  这里会触发加载这个 merchant 对象并返回一个正确的名字

SmartList<Product> products = merchant.getProductList(); //null，get 方法

products = merchant.productList(); //懒加载方法，这里会触发加载这个 merchant 下面所有的 products

这里 Product 同样作为一个模型对象，里面的属性同样具有懒加载的方法

注意：

对于模型对象的加载，比如 merchant，会一次加载 merchant 的所有属性。对下层对象，比如 merchant 下面的 product，这里只有在 productList 为空时才会尝试加载。

多次调用并不会导致多次加载，我们在成功加载后会标记已经加载。

调用 get 方法并不能触发懒加载，只有在调用懒加载方法时才会触发懒加载。

## **3.Id  查询**

对象的 Id 查询建议采用以下的方式

Merchant merchant = dbutil.reload(Merchant.withId(“M000001”));

这种查询会尝试用内存中的缓存，以减少数据库查询。

## **4.基本模板查询**

DBUtil 提供了模板查询功能，下面以 order 为例介绍常用方式

在模板查询前，有一个目标的查询对象，这里就是 Order

A.获得一个模板对象,  所有的模型对象都有一个 searchExample 方法，

Order order = Order.searchExample();

B.  在查询模板中增加查询条件

//简单属性，联系电话为 13888888888

order.updateContactPhone(“13888888888”);

//复杂属性，定单为已完成

order.updateStatus(OrderStatus.withId(OrderStatus.COMPLETED));

//复杂属性， buyer  的 name 为双链科技

order.updateBuyer(Merchant.searchExample().updateName(“双链科技”)));

C.  可能的排序

order.orderByCreateTime(true); //按 create time 升序， false 时为降序

D.  可能的分页

order.limit(10, 5); //从第 10 条开始，返回 5 条

E.  查询

SmartList<Order> orders = dbutil.search(order); //查询结果

Order oneOrder = dbutil.searchOne(order); //查询结果，并且查询一个

注意：

上面的属性约束之间是 and 关系。

## **5.模板查询高级比较查询**

模板对象除了可以用 update 方法来设置简单的查询条件（相等）外，提供了更多的属性约束的设置方法

//查询总金额大于 100 的订单

order.addAmountCriteria(QueryOperator.GREATER_THAN, 100);

//员工编号为 E000001 或 E000002 的下的单

order.addCreatorCriteria(

QueryOperator.IN, Employee.withId(“E000001”), Employee.withId(“E000002”));

更多的比较运算符请参考 QueryOperator，里面有几乎所有的比较操作

以上所有的约束，都是 and  关系

## **6.模板查询的逻辑关系**

除了上面提供的基本比较操作，我们也可以组装更为复杂的逻辑约束

在所有的模板对象都继承了 BaseEntity，  在 BaseEntity 中有一个增加查询条件的方法：

public void doAddCriteria(SearchCriteria criteria)

下面介绍这个 SearchCriteria

所有的比较查询（比如 order.addAmountCriteria(QueryOperator.GREATER_THAN, 100)）

实质上是两个步骤

1.创建一个 SearchCriteria

SearchCriteria criteria =

order.createAmountCriteria(QueryOperator.GREATER_THAN, 100);

2.调用 doAddCriteria 把这个新建的 SearchCriteria 加到查询模板中

order.doAddCriteria(criteria);

同时在 SearchCriteria 中我们有提供基本了基本的逻辑关系

static SearchCriteria and(SearchCriteria... sub) {
return new AddCriteria(sub);
}

static SearchCriteria or(SearchCriteria... sub) {
return new OrCriteria(sub);
}

static SearchCriteria not(SearchCriteria sub) {
return new NotCriteria(sub);
}

通过这些方法可以自由组件查询条件

比如：

//金额  >= 100

order.createAmountCriteria(QueryOperator.GREATER_THAN, 100);

//金额  <= 1000

order.createAmountCriteria(QueryOperator.GREATER_THAN, 100);

//  已完成的定单

order.updateStatus(OrderStatus.withId(OrderStatus.COMPLETED));

//  已取消的定单

order.updateStatus(OrderStatus.withId(OrderStatus.CANCELLED));

//  金额  >= 100 and 金额  <= 1000

SearchCriteria.and(

order.createAmountCriteria(QueryOperator.GREATER_THAN, 100),

order.createAmountCriteria(QueryOperator.GREATER_THAN, 100));

//已完成或者金额大于 100

SearchCriteria.or(

order.updateStatus(OrderStatus.withId(OrderStatus.COMPLETED)),

order.createAmountCriteria(QueryOperator.GREATER_THAN, 100)));

## 7.**查询结果增强**

我们可以用查询模板以及懒加载覆盖大多数场景

比如可以 Order 模板查询到  orderList

可以通过懒加载得到所有信息

order.itemList();  //懒加载得到这个 order 下面的所有 item

order.shippingList(); //懒加载得到这个 order 下面的所有 shipping

order.seller();  //卖家

order.seller().warehouseList(); //卖家的所有仓库

但是有个前提是这需要调用懒加载方法，在业务方法中需要调用这个懒加载，这不是一个大的问题，这也是懒加载的常用场景。但是有些时候在业务方法中并不会调用这些懒加载方法，

这样会导致这些信息并不会加载。

懒加载的另外一个问题是查询次数太多，下面是常见的查询过程分析：

1.通过 order 的模板，查询所有满足条件的 order

2.对于每个 order，都在 itemList()中查询一次该 order 下面的所有 item

3.对于每个 order，都在 shippingList()中查询一次该 order 下面的所有 Shipping

4.对于每个 order 的 seller，都在 order.seller().warehouseList()中查询它的所有仓库

为了解决这些问题，我们用到了查询结果增强特性

查询结果增强也是在查询模板中指明：

步骤为：

获得一个查询模板

Order order = Order.searchExample();

设置查询约束，以及排序等

.....

order.want(Item.class); //我想在结果中有 item 信息

order.want(Shipping.class); //我想在结果中有 shipping 信息

同时也可以等价的用

order.wants(Item.class, Shipping.class);

order.want(Merchant.class) //我想要卖家信息

order.want(Merchant.class, Warehouse.class) //我想要卖家以及其所有仓库信息

这样在查询结果中就有尽可能的 merge 查询并增强查询结果。
