

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './GoodsAllocation.profile.less'
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
const internalSummaryOf = (goodsAllocation,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{goodsAllocation.id}</Description> 
<Description term="位置">{goodsAllocation.location}</Description> 
<Description term="纬度">{goodsAllocation.latitude}</Description> 
<Description term="经度">{goodsAllocation.longitude}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = goodsAllocation => {
  const {GoodsAllocationBase} = GlobalComponents
  return <PermissionSetting targetObject={goodsAllocation}  targetObjectMeta={GoodsAllocationBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class GoodsAllocationPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  goodsAllocation = this.props.goodsAllocation
    const { id,displayName, goodsCount } = goodsAllocation
    const  returnURL = `/goodsAllocation/${id}/dashboard`
    const cardsData = {cardsName:"货位",cardsFor: "goodsAllocation",cardsSource: goodsAllocation,displayName,returnURL,
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
  goodsAllocation: state._goodsAllocation,
}))(Form.create()(GoodsAllocationPermission))

