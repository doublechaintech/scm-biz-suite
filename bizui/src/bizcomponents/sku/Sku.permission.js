

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
import styles from './Sku.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (sku,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{sku.id}</Description> 
<Description term="Name">{sku.name}</Description> 
<Description term="Size">{sku.size}</Description> 
<Description term="Barcode">{sku.barcode}</Description> 
<Description term="Package Type">{sku.packageType}</Description> 
<Description term="Net Content">{sku.netContent}</Description> 
<Description term="Price">{sku.price}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = sku => {
  const {SkuBase} = GlobalComponents
  return <PermissionSetting targetObject={sku}  targetObjectMeta={SkuBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SkuPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  sku = this.props.sku;
    const { id,displayName, goodsCount } = sku
    const cardsData = {cardsName:"Sku",cardsFor: "sku",cardsSource: sku,
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
  sku: state._sku,
}))(Form.create()(SkuPermission))

