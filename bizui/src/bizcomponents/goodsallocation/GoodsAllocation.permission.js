

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
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


const internalSummaryOf = (goodsAllocation,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{goodsAllocation.id}</Description> 
<Description term="Location">{goodsAllocation.location}</Description> 
<Description term="Latitude">{goodsAllocation.latitude}</Description> 
<Description term="Longitude">{goodsAllocation.longitude}</Description> 
	
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
    const  goodsAllocation = this.props.goodsAllocation;
    const { id,displayName, goodsCount } = goodsAllocation
    const cardsData = {cardsName:"Goods Allocation",cardsFor: "goodsAllocation",cardsSource: goodsAllocation,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
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

