

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
import styles from './SupplierSpace.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (supplierSpace,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{supplierSpace.id}</Description> 
<Description term="Location">{supplierSpace.location}</Description> 
<Description term="Contact Number">{supplierSpace.contactNumber}</Description> 
<Description term="Total Area">{supplierSpace.totalArea}</Description> 
<Description term="Latitude">{supplierSpace.latitude}</Description> 
<Description term="Longitude">{supplierSpace.longitude}</Description> 
<Description term="Last Update Time">{ moment(supplierSpace.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = supplierSpace => {
  const {SupplierSpaceBase} = GlobalComponents
  return <PermissionSetting targetObject={supplierSpace}  targetObjectMeta={SupplierSpaceBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SupplierSpacePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  supplierSpace = this.props.supplierSpace;
    const { id,displayName, goodsShelfCount } = supplierSpace
    const cardsData = {cardsName:"Supplier Space",cardsFor: "supplierSpace",cardsSource: supplierSpace,
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
  supplierSpace: state._supplierSpace,
}))(Form.create()(SupplierSpacePermission))

