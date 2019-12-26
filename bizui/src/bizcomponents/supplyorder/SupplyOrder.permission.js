

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './SupplyOrder.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (supplyOrder,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{supplyOrder.id}</Description> 
<Description term="头衔">{supplyOrder.title}</Description> 
<Description term="总金额">{supplyOrder.totalAmount}</Description> 
<Description term="最后更新时间">{ moment(supplyOrder.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<<<<<<< HEAD
<Description term="当前状态">{supplyOrder.currentStatus}</Description> 
=======
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
	
      </DescriptionList>
	)
}


const renderPermissionSetting = supplyOrder => {
  const {SupplyOrderBase} = GlobalComponents
  return <PermissionSetting targetObject={supplyOrder}  targetObjectMeta={SupplyOrderBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SupplyOrderPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  supplyOrder = this.props.supplyOrder
    const { id,displayName, supplyOrderLineItemCount, supplyOrderShippingGroupCount, supplyOrderPaymentGroupCount, goodsCount } = supplyOrder
    const  returnURL = `/supplyOrder/${id}/dashboard`
    const cardsData = {cardsName:"供应订单",cardsFor: "supplyOrder",cardsSource: supplyOrder,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  supplyOrder: state._supplyOrder,
}))(Form.create()(SupplyOrderPermission))

