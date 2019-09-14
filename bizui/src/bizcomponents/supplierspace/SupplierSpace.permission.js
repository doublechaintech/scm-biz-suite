

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
import styles from './SupplierSpace.profile.less'
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
const internalSummaryOf = (supplierSpace,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{supplierSpace.id}</Description> 
<Description term="位置">{supplierSpace.location}</Description> 
<Description term="联系电话">{supplierSpace.contactNumber}</Description> 
<Description term="总面积">{supplierSpace.totalArea}</Description> 
<Description term="纬度">{supplierSpace.latitude}</Description> 
<Description term="经度">{supplierSpace.longitude}</Description> 
<Description term="最后更新时间">{ moment(supplierSpace.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
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
    const  supplierSpace = this.props.supplierSpace
    const { id,displayName, goodsShelfCount } = supplierSpace
    const  returnURL = `/supplierSpace/${id}/dashboard`
    const cardsData = {cardsName:"供应商的空间",cardsFor: "supplierSpace",cardsSource: supplierSpace,displayName,returnURL,
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
  supplierSpace: state._supplierSpace,
}))(Form.create()(SupplierSpacePermission))

