

import BookSharingPlatformDashboard from '../../bizcomponents/booksharingplatform/BookSharingPlatform.dashboard'

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import {Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal,List } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './BookSharingPlatform.dashboardex.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


/*

const menuData = {menuName:"图书共享平台", menuFor: "bookSharingPlatform",
  		subItems: [
  {name: 'platformConfigurationList', displayName:'平台配置', icon:'at'},
  {name: 'accountDataList', displayName:'帐户数据', icon:'database'},
  {name: 'cityList', displayName:'城市', icon:'glass'},
  {name: 'bookPlazaList', displayName:'图书天地', icon:'book'},
  {name: 'memberServiceProductList', displayName:'会员服务产品', icon:'glass'},
  {name: 'mainOrderList', displayName:'主订单', icon:'glass'},
  {name: 'bookList', displayName:'书', icon:'book'},
  {name: 'platformAccountList', displayName:'平台账户', icon:'at'},
  {name: 'fundationAccountList', displayName:'平台基金账户', icon:'at'},
  {name: 'storeList', displayName:'服务网点', icon:'glass'},
  {name: 'campaignPlazaList', displayName:'活动广场', icon:'glass'},
  {name: 'customerList', displayName:'用户', icon:'glass'},
  {name: 'employeeList', displayName:'员工', icon:'glass'},
  {name: 'undistributedProfitList', displayName:'未分配利润', icon:'glass'},
  
  		],
}



*/
const topColResponsiveProps = {
  xs: 8,
  sm: 6,
  md: 6,
  lg: 4,
  xl: 4,
  style: { marginBottom: 24 },
}
const panesData =[

  {name:'用户管理中心',subItems:["customerList"]},
  {name:'网点管理中心',subItems:["storeList"]},
  {name:'订单管理中心',subItems:["mainOrderList"]},
  {name:'图书管理中心',subItems:["bookPlazaList"]},
  {name:'活动管理中心',subItems:["campaignPlazaList"]},
  
  {name:'基础设置中心',subItems:["platformConfigurationList",
  "accountDataList","cityList","memberServiceProductList","platformAccountList","fundationAccountList"]},
  {name:'经营成果中心',subItems:["undistributedProfitList"]},
  
  //

]
const subListWithPans = (cardsData,tabbedPaneData) => {
  const {id} = cardsData.cardsSource;
  return (<Row gutter={12}>

    <Tabs  size="large" tabBarStyle={{ marginBottom: 24 }}>

    {
      tabbedPaneData.map((paneItem)=>{return(
        <TabPane tab={paneItem.name} key={paneItem.name} >
        {
          paneItem.subItems.map(paneItemSubitem=>{
            
            return cardsData.subItems.filter(item=>item.name==paneItemSubitem).map(item=>{
             
              return(

                <Col {...topColResponsiveProps} key={item.name}>   
                <Badge count={item.count} style={{ backgroundColor: '#52c41a' }} overflowCount={9999999999}>        
                 <Card title={`${item.displayName}(${numeral(item.count).format('0,0')})`}  style={{ width: 180 }}>             
                 <p>

<Link to={`/${cardsData.cardsFor}/${id}/list/${item.name}/${item.displayName}列表`}><FontAwesome name="list"  />&nbsp;管理</Link>
{item.addFunction&&(<Link to={`/${cardsData.cardsFor}/${id}/list/${item.role}CreateForm`}><span className={styles.splitLine}></span><FontAwesome name="plus"  />&nbsp;新增</Link>)}   
</p> 


               </Card> </Badge>
                 </Col>)

            })

          })

        }
        </TabPane>)
      })

    }
           
            </Tabs>
        </Row>)

}
const subListsOf = (cardsData) =>{

	return subListWithPans(cardsData,panesData)
}


class BookSharingPlatformDashboardEx extends Component {

  render() {
    return (<BookSharingPlatformDashboard subListsOf={subListsOf}/>)
  }


}

export default connect(state => ({
  bookSharingPlatform: state._bookSharingPlatform,
}))(BookSharingPlatformDashboardEx)



/*

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch  } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './BookSharingPlatform.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker

*/

