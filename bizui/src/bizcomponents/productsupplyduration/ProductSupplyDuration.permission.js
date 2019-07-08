

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
import styles from './ProductSupplyDuration.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (productSupplyDuration,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{productSupplyDuration.id}</Description> 
<Description term="Quantity">{productSupplyDuration.quantity}</Description> 
<Description term="Duration">{productSupplyDuration.duration}</Description> 
<Description term="Price">{productSupplyDuration.price}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = productSupplyDuration => {
  const {ProductSupplyDurationBase} = GlobalComponents
  return <PermissionSetting targetObject={productSupplyDuration}  targetObjectMeta={ProductSupplyDurationBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ProductSupplyDurationPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  productSupplyDuration = this.props.productSupplyDuration;
    const { id,displayName,  } = productSupplyDuration
    const cardsData = {cardsName:"Product Supply Duration",cardsFor: "productSupplyDuration",cardsSource: productSupplyDuration,
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
  productSupplyDuration: state._productSupplyDuration,
}))(Form.create()(ProductSupplyDurationPermission))

