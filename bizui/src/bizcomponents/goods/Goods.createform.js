import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import SelectObject from '../../components/SelectObject'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './Goods.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import GoodsBase from './Goods.base'

const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  name: '可口可乐',
  rfid: 'RF99192',
  uom: '件',
  maxPackage: '9',
  expireTime: '2018-01-06',
  skuId: 'S000001',
  receivingSpaceId: 'RS000001',
  goodsAllocationId: 'GA000001',
  smartPalletId: 'SP000001',
  shippingSpaceId: 'SS000001',
  transportTaskId: 'TT000001',
  retailStoreId: 'RS000001',
  bizOrderId: 'SO000001',
  retailStoreOrderId: 'RSO000001',
}
*/

const imageKeys = [
]


class GoodsCreateForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {
	
    
    
  }

  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

 



  handleChange = (event, source) => {
    console.log('get file list from change in update change:', source)

    const { fileList } = event
    const { convertedImagesValues } = this.state

    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change:', source)
  }
	
  

  render() {
    const { form, dispatch, submitting, role } = this.props
    const { convertedImagesValues } = this.state

    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = GoodsBase
    const {GoodsService} = GlobalComponents
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    const submitCreateForm = () => {
      validateFieldsAndScroll((error, values) => {
        if (error) {
          console.log('code go here', error)
          return
        }

        const { owner } = this.props
        const imagesValues = mapBackToImageValues(convertedImagesValues)

        const parameters = { ...values, ...imagesValues }
        const cappedRoleName = capFirstChar(role)
        dispatch({
          type: `${owner.type}/add${cappedRoleName}`,
          payload: { id: owner.id, role: role, parameters },
        })
      })
    }
    const submitCreateFormAndContinue = () => {
      validateFieldsAndScroll((error, values) => {
        if (error) {
          console.log('code go here', error)
          return
        }
        
        const { owner } = this.props
        const imagesValues = mapBackToImageValues(convertedImagesValues)
        
        const parameters = { ...values, ...imagesValues }
        dispatch({
          type: `${owner.type}/addGoods`,
          payload: { id: owner.id, type: 'goods', parameters, continueNext: true },
        })
      })
    }
    
    const goback = () => {
      const { owner } = this.props
      dispatch({
        type: `${owner.type}/goback`,
        payload: { id: owner.id, type: 'goods',listName:'货物列表' },
      })
    }
    const errors = getFieldsError()
    const getErrorInfo = () => {
      const errorCount = Object.keys(errors).filter(key => errors[key]).length
      if (!errors || errorCount === 0) {
        return null
      }
      // eslint-disable-next-line no-unused-vars
      const scrollToField = (fieldKey) => {
        const labelNode = document.querySelector('label[for="${fieldKey}"]')
        if (labelNode) {
          labelNode.scrollIntoView(true)
        }
      }
      const errorList = Object.keys(errors).map((key) => {
        if (!errors[key]) {
          return null
        }
        return (
          <li key={key} className={styles.errorListItem} onClick={() => scrollToField(key)}>
            <Icon type="cross-circle-o" className={styles.errorIcon} />
            <div className={styles.errorMessage}>{errors[key][0]}</div>
            <div className={styles.errorField}>{fieldLabels[key]}</div>
          </li>
        )
      })
      return (
        <span className={styles.errorIcon}>
          <Popover
            title="表单校验信息"
            content={errorList}
            overlayClassName={styles.errorPopover}
            trigger="click"
            getPopupContainer={trigger => trigger.parentNode}
          >
            <Icon type="exclamation-circle" />
          </Popover>
          {errorCount}
        </span>
      )
    }
    

    
    
    const tryinit  = (fieldName) => {
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
    const formItemLayout = {
      labelCol: { span: 10 },
      wrapperCol: { span: 14 },
    }
    const switchFormItemLayout = {
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    }
    return (
      <PageHeaderLayout
        title="新建一个货物"
        content="新建一个货物"
        wrapperClassName={styles.advancedForm}
      >
        <Card title="基础信息" className={styles.card} bordered={false}>
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.name} {...formItemLayout}>
                  {getFieldDecorator('name', {
                    rules: [{ required: true, message: '请输入名称' }],
                  })(
                    <Input placeholder="请输入名称" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.rfid} {...formItemLayout}>
                  {getFieldDecorator('rfid', {
                    rules: [{ required: true, message: '请输入RFID' }],
                  })(
                    <Input placeholder="请输入RFID" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.uom} {...formItemLayout}>
                  {getFieldDecorator('uom', {
                    rules: [{ required: true, message: '请输入计量单位' }],
                  })(
                    <Input placeholder="请输入计量单位" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.maxPackage} {...formItemLayout}>
                  {getFieldDecorator('maxPackage', {
                    rules: [{ required: true, message: '请输入最大包装' }],
                  })(
                    <Input placeholder="请输入最大包装" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.expireTime} {...formItemLayout}>
                  {getFieldDecorator('expireTime', {
                    rules: [{ required: true, message: '请输入到期时间' }],
                  })(
                    <DatePicker format="YYYY-MM-DD" placeholder="请输入到期时间" />
                  )}
                </Form.Item>
              </Col>

            </Row>
          </Form>
        </Card>



       
        









        <Card title="关联" className={styles.card} bordered={false}>
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.sku} {...formItemLayout}>
                  {getFieldDecorator('skuId', {
                  	initialValue: tryinit('sku'),
                    rules: [{ required: true, message: '请输入SKU' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('sku')}
                    targetType={"sku"} 
                    requestFunction={GoodsService.requestCandidateSku}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.receivingSpace} {...formItemLayout}>
                  {getFieldDecorator('receivingSpaceId', {
                  	initialValue: tryinit('receivingSpace'),
                    rules: [{ required: true, message: '请输入收货区' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('receivingSpace')}
                    targetType={"receivingSpace"} 
                    requestFunction={GoodsService.requestCandidateReceivingSpace}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.goodsAllocation} {...formItemLayout}>
                  {getFieldDecorator('goodsAllocationId', {
                  	initialValue: tryinit('goodsAllocation'),
                    rules: [{ required: true, message: '请输入货位' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('goodsAllocation')}
                    targetType={"goodsAllocation"} 
                    requestFunction={GoodsService.requestCandidateGoodsAllocation}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.smartPallet} {...formItemLayout}>
                  {getFieldDecorator('smartPalletId', {
                  	initialValue: tryinit('smartPallet'),
                    rules: [{ required: true, message: '请输入智能托盘' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('smartPallet')}
                    targetType={"smartPallet"} 
                    requestFunction={GoodsService.requestCandidateSmartPallet}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.shippingSpace} {...formItemLayout}>
                  {getFieldDecorator('shippingSpaceId', {
                  	initialValue: tryinit('shippingSpace'),
                    rules: [{ required: true, message: '请输入发货区' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('shippingSpace')}
                    targetType={"shippingSpace"} 
                    requestFunction={GoodsService.requestCandidateShippingSpace}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.transportTask} {...formItemLayout}>
                  {getFieldDecorator('transportTaskId', {
                  	initialValue: tryinit('transportTask'),
                    rules: [{ required: true, message: '请输入运输任务' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('transportTask')}
                    targetType={"transportTask"} 
                    requestFunction={GoodsService.requestCandidateTransportTask}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.retailStore} {...formItemLayout}>
                  {getFieldDecorator('retailStoreId', {
                  	initialValue: tryinit('retailStore'),
                    rules: [{ required: true, message: '请输入双链小超' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('retailStore')}
                    targetType={"retailStore"} 
                    requestFunction={GoodsService.requestCandidateRetailStore}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.bizOrder} {...formItemLayout}>
                  {getFieldDecorator('bizOrderId', {
                  	initialValue: tryinit('bizOrder'),
                    rules: [{ required: true, message: '请输入订单' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('bizOrder')}
                    targetType={"bizOrder"} 
                    requestFunction={GoodsService.requestCandidateBizOrder}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.retailStoreOrder} {...formItemLayout}>
                  {getFieldDecorator('retailStoreOrderId', {
                  	initialValue: tryinit('retailStoreOrder'),
                    rules: [{ required: true, message: '请输入生超的订单' }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('retailStoreOrder')}
                    targetType={"retailStoreOrder"} 
                    requestFunction={GoodsService.requestCandidateRetailStoreOrder}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

            </Row>
          </Form>  
        </Card>

        <FooterToolbar>
          {getErrorInfo()}
          <Button type="primary" onClick={submitCreateForm} loading={submitting} htmlType="submit">
            提交
          </Button>
          <Button type="primary" onClick={submitCreateFormAndContinue} loading={submitting}>
            提交并建下一个
          </Button>
          <Button type="danger" onClick={goback} loading={submitting}>
            放弃
          </Button>
        </FooterToolbar>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(GoodsCreateForm))




