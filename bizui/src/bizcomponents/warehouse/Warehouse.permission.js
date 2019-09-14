

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
import styles from './Warehouse.profile.less'
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
const internalSummaryOf = (warehouse,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{warehouse.id}</Description> 
<Description term="位置">{warehouse.location}</Description> 
<Description term="联系电话">{warehouse.contactNumber}</Description> 
<Description term="总面积">{warehouse.totalArea}</Description> 
<Description term="纬度">{warehouse.latitude}</Description> 
<Description term="经度">{warehouse.longitude}</Description> 
<Description term="最后更新时间">{ moment(warehouse.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = warehouse => {
  const {WarehouseBase} = GlobalComponents
  return <PermissionSetting targetObject={warehouse}  targetObjectMeta={WarehouseBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class WarehousePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  warehouse = this.props.warehouse
    const { id,displayName, storageSpaceCount, smartPalletCount, supplierSpaceCount, receivingSpaceCount, shippingSpaceCount, damageSpaceCount, warehouseAssetCount } = warehouse
    const  returnURL = `/warehouse/${id}/dashboard`
    const cardsData = {cardsName:"仓库",cardsFor: "warehouse",cardsSource: warehouse,displayName,returnURL,
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
  warehouse: state._warehouse,
}))(Form.create()(WarehousePermission))

