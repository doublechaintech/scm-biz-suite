

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
import styles from './GoodsSupplier.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (goodsSupplier,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{goodsSupplier.id}</Description> 
<Description term="Name">{goodsSupplier.name}</Description> 
<Description term="Supply Product">{goodsSupplier.supplyProduct}</Description> 
<Description term="Contact Number">{goodsSupplier.contactNumber}</Description> 
<Description term="Description">{goodsSupplier.description}</Description> 
<Description term="Last Update Time">{ moment(goodsSupplier.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = goodsSupplier => {
  const {GoodsSupplierBase} = GlobalComponents
  return <PermissionSetting targetObject={goodsSupplier}  targetObjectMeta={GoodsSupplierBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class GoodsSupplierPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  goodsSupplier = this.props.goodsSupplier;
    const { id,displayName, supplierProductCount, supplyOrderCount, accountSetCount } = goodsSupplier
    const cardsData = {cardsName:"Goods Supplier",cardsFor: "goodsSupplier",cardsSource: goodsSupplier,
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
  goodsSupplier: state._goodsSupplier,
}))(Form.create()(GoodsSupplierPermission))

