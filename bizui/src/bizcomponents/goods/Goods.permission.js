

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Goods.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (goods,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{goods.id}</Description> 
<Description term="名称">{goods.name}</Description> 
<Description term="RFID">{goods.rfid}</Description> 
<Description term="计量单位">{goods.uom}</Description> 
<Description term="最大包装">{goods.maxPackage}</Description> 
<Description term="到期时间">{ moment(goods.expireTime).format('YYYY-MM-DD')}</Description> 
<Description term="当前状态">{goods.currentStatus}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = goods => {
  const {GoodsBase} = GlobalComponents
  return <PermissionSetting targetObject={goods}  targetObjectMeta={GoodsBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class GoodsPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  goods = this.props.goods
    const { id,displayName, goodsMovementCount } = goods
    const  returnURL = `/goods/${id}/dashboard`
    const cardsData = {cardsName:"货物",cardsFor: "goods",cardsSource: goods,displayName,returnURL,
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
  goods: state._goods,
}))(Form.create()(GoodsPermission))

