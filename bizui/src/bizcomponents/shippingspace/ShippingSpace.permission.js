

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
import styles from './ShippingSpace.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (shippingSpace,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{shippingSpace.id}</Description> 
<Description term="Location">{shippingSpace.location}</Description> 
<Description term="Contact Number">{shippingSpace.contactNumber}</Description> 
<Description term="Total Area">{shippingSpace.totalArea}</Description> 
<Description term="Latitude">{shippingSpace.latitude}</Description> 
<Description term="Longitude">{shippingSpace.longitude}</Description> 
<Description term="Description">{shippingSpace.description}</Description> 
<Description term="Last Update Time">{ moment(shippingSpace.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = shippingSpace => {
  const {ShippingSpaceBase} = GlobalComponents
  return <PermissionSetting targetObject={shippingSpace}  targetObjectMeta={ShippingSpaceBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ShippingSpacePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  shippingSpace = this.props.shippingSpace;
    const { id,displayName, goodsCount } = shippingSpace
    const cardsData = {cardsName:"Shipping Space",cardsFor: "shippingSpace",cardsSource: shippingSpace,
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
  shippingSpace: state._shippingSpace,
}))(Form.create()(ShippingSpacePermission))

